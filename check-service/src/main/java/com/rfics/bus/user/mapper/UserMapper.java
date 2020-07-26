package com.rfics.bus.user.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.rfics.bus.user.entity.Token;
import com.rfics.bus.user.entity.Users;

@Mapper
public interface UserMapper {

	public Users getUser(Users user);
	public int insertToken(Token token);
	public int updateToken(Token token);
	public int deleteToken(Token token);
	public Token getToken(Map map);
	public int updateUser(Users user);

}
