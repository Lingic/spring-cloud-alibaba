package com.rfics.bus.user.service.impl;

import java.math.BigDecimal;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.rfics.bus.user.entity.Token;
import com.rfics.bus.user.entity.Users;
import com.rfics.bus.user.mapper.UserMapper;
import com.rfics.bus.user.service.UserService;
import com.rfics.unit.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public ResponseMessage login(Users user) {
		ResponseMessage res = new ResponseMessage();
		Users users = null;
		try {
			users = userMapper.getUser(user);
		}catch (DataAccessException e) {
			log.error("error",e);
			res.setRc("900006");
			res.setRt("登录异常");
			return res;
		}
		if(users == null) {
			res.setRc("000001");
			res.setRt("用户名或密码错误");
			return res;
		}else{
			String tokenS = null;
			try {
				tokenS = getToken(user);
			} catch (Exception e) {
				res.setRc("000001");
				res.setRt("获取Token异常");
				return res;
			}
			res.setRc("000000");
			res.setRt("登录成功");
			Map<String, Object> map= new HashMap<String, Object>();
			map.put("token",tokenS);
			map.put("userName",user.getUserName());
			map.put("loginTime",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			res.setRb(map);
		}
		return res;
	}
	private String getToken(Users user) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName",user.getUserName());
		Token token = null;
		try {
			token = userMapper.getToken(map);
		}catch (DataAccessException e) {
			e.printStackTrace();
		}
		
		if(token == null ) {
			StringBuilder paramBuilder = new StringBuilder();
			token = new Token();
	        /** 当前时间（毫秒） */
	        long genTime = new Date().getTime();
	        Timestamp genTimestamp = new Timestamp(genTime);
	        /** token生成时间（毫秒） */
	        token.setTokenGenTime(genTimestamp);
	        /** token过期时间（毫秒） */
	        long expireTime = Long.parseLong(new BigDecimal(genTime).add(new BigDecimal(1000*60*30)).toString());
	        token.setTokenExpireTime(new Timestamp(expireTime));
	        UUID uuid = UUID.randomUUID();
	        /** 拼接生成token字符串 */
	        paramBuilder.append(user.getUserName()).append(genTime).append(uuid);
	        /** 根据参数条件、MD5加密生成token */
	        try
	        {
	          byte[] btInput = paramBuilder.toString().getBytes();
	          MessageDigest mdInst = MessageDigest.getInstance("MD5");
	          mdInst.update(btInput);
	          byte[] md = mdInst.digest();
	          StringBuffer sb = new StringBuffer();
	          for (int i = 0; i < md.length; i++) {
	            int val = md[i] & 0xFF;
	            if (val < 16)
	              sb.append("0");
	            sb.append(Integer.toHexString(val));
	          }
	          String tokenStr =  sb.toString().toUpperCase();
	          token.setId(uuid.toString());
	          token.setToken(tokenStr);
	          token.setUserName(user.getUserName());
	          try {
	        	  userMapper.insertToken(token);
	          }catch (DataAccessException e) {
	        	  e.printStackTrace();
			}
	          return sb.toString().toUpperCase(); 
	        } catch (Exception e) {
	        	e.printStackTrace();
          }
		}else{
			long expireTime = Long.parseLong(new BigDecimal(new Date().getTime()).add(new BigDecimal(1000*60*30)).toString());
			token.setTokenExpireTime(new Timestamp(expireTime));
			try {
				userMapper.updateToken(token);
			}catch (DataAccessException e) {
				e.printStackTrace();
			}
			return token.getToken();
		}
		return "";
	}
	@Override
	public ResponseMessage logout(Token token) {
		ResponseMessage res = new ResponseMessage();
		try {
			int i = userMapper.deleteToken(token);
			if(i <= 0) {
				res.setRc("900006");
				res.setRt("登出失败");
			}else{
				res.setRc("000000");
				res.setRt("登出成功");
			}
		}catch (DataAccessException e) {
			log.error("error",e);
			res.setRc("900006");
			res.setRt("登出异常");
			return res;
		}
		return res;
	}
	@Override
	public ResponseMessage resetPwd(Users user) {
		ResponseMessage res = new ResponseMessage();
		try {
			int i = userMapper.updateUser(user);;
			if(i <= 0) {
				res.setRc("000007");
				res.setRt("修改失败");
			}else{
				res.setRc("000000");
				res.setRt("修改成功");
			}
		}catch (DataAccessException e) {
			log.error("error",e);
			res.setRc("900007");
			res.setRt("重置密码异常");
			return res;
		}
		return res;
	}
}
