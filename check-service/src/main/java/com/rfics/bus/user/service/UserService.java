package com.rfics.bus.user.service;

import com.rfics.bus.user.entity.Token;
import com.rfics.bus.user.entity.Users;
import com.rfics.unit.ResponseMessage;

public interface UserService {

	ResponseMessage login(Users user);

	ResponseMessage logout(Token token);

	ResponseMessage resetPwd(Users user);

}
