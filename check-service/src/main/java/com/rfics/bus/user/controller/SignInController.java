package com.rfics.bus.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfics.unit.ContantMode;
import com.rfics.unit.JsonUtils;
import com.rfics.unit.ResponseMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/sign")
public class SignInController {

	@PostMapping(value="signIn", produces="application/json;charset=UTF-8")
	public ResponseMessage signIn(@RequestBody Map<String,Object> map) {
		log.info("signIn");
		
		ResponseMessage res = new ResponseMessage();
		
		try {
			String username = map.get("username").toString();
			String password = map.get("password").toString();
			
			List<Map<String, String>> list = JsonUtils.readJsonFromClassPath("sign.json", List.class);
			for (Iterator<Map<String, String>> iter = list.iterator(); iter.hasNext(); ) {
				Map<String, String> signMap = iter.next();
				log.info(signMap.get("username") + " - " + signMap.get("password"));
				if (username.equals(signMap.get("username"))) {
					Map<String, Object> rb = new HashMap<>();
					if (password.equals(signMap.get("password"))) {
						rb.put("signIn", "success");
						res.setRb(rb);
						
						break;
					} else {
						rb.put("signIn", "failure");
						res.setRb(rb);
						res.setRc("900001");
			    		res.setRt("SignIn Failed");
			    		return res;
					}
				}
			}
			
			
		} catch (IOException e) {
			log.error("Error", e);
			res.setRc("900001");
    		res.setRt("SignIn Failed");
    		return res;
		}
		
		res.setRc(ContantMode.SUCCESS);
		res.setRt(ContantMode.SUCCESS_TEXT);
		return res;
	}
}
