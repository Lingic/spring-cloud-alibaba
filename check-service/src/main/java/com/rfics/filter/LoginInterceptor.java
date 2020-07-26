package com.rfics.filter;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import com.rfics.bus.user.entity.Token;
import com.rfics.bus.user.mapper.UserMapper;
import com.rfics.unit.ResponseMessage;

import net.sf.json.JSONObject;

public class LoginInterceptor  implements HandlerInterceptor {
	
	@Autowired
	private UserMapper userMapper;

	@Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse rep, Object o) throws Exception {
		if("OPTIONS".equals(req.getMethod())) {
			return true;
		}
		String token = req.getHeader("token");
        if(StringUtils.isEmpty(token)){
        	rep.setCharacterEncoding("UTF-8");
        	rep.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            ResponseMessage res = new ResponseMessage();
            res.setRc("999999");
            res.setRt("token不存在，请先登录");
            JSONObject json =JSONObject.fromObject(res);
            out = rep.getWriter();
            out.append(json.toString());
            return false;
        }else{
        	Map<String, Object> map = new HashMap<String, Object>();
        	map.put("token",token);
        	Token tokenS = userMapper.getToken(map);
        	if(tokenS == null || tokenS.getToken()==null || !token.equals(tokenS.getToken())) {
            	rep.setCharacterEncoding("UTF-8");
            	rep.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                ResponseMessage res = new ResponseMessage();
                res.setRc("999998");
                res.setRt("token错误，请先登录");
                JSONObject json =JSONObject.fromObject(res);
                out = rep.getWriter();
                out.append(json.toString());
                return false;
        	}else if(tokenS.getTokenExpireTime().compareTo(new Date()) < 0){
        		rep.setCharacterEncoding("UTF-8");
            	rep.setContentType("application/json; charset=utf-8");
                PrintWriter out = null;
                ResponseMessage res = new ResponseMessage();
                res.setRc("999997");
                res.setRt("token过期，请重新登录");
                JSONObject json =JSONObject.fromObject(res);
                out = rep.getWriter();
                out.append(json.toString());
                return false;
        	}else {
    			long expireTime = Long.parseLong(new BigDecimal(new Date().getTime()).add(new BigDecimal(1000*60*30)).toString());
    			tokenS.setTokenExpireTime(new Timestamp(expireTime));
    			userMapper.updateToken(tokenS);
    			return true;
        	}
        }
    }
}
