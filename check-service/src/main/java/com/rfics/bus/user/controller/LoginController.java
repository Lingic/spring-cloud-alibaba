package com.rfics.bus.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rfics.bus.user.entity.Token;
import com.rfics.bus.user.entity.Users;
import com.rfics.bus.user.service.UserService;
import com.rfics.unit.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public ResponseMessage login(@RequestBody Users user) {
		ResponseMessage res = new ResponseMessage();
		res = userService.login(user);
		return res;
	}
	@RequestMapping(value = "/logout",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public ResponseMessage logout(@RequestBody Token token) {
		ResponseMessage res = new ResponseMessage();
		res = userService.logout(token);
		return res;
	}
	@RequestMapping(value = "/resetPwd",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
	public ResponseMessage resetPwd(@RequestBody Users user) {
		ResponseMessage res = new ResponseMessage();
		res = userService.resetPwd(user);
		return res;
	}
}
