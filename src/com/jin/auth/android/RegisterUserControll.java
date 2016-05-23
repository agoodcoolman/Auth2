package com.jin.auth.android;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.jin.auth.android.modle.Status;
import com.locator.ServiceLocal;
import com.police.modle.User;

@Controller
public class RegisterUserControll {

	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String register(@RequestParam(value="email")String email
			, @RequestParam(value="password")String password,
			@RequestParam(value="username")String username,
			@RequestParam(value="mobile")String mobile, 
			@RequestParam(value="portrait")String portrait) {
		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		user.setMobile(mobile);
		user.setPortrait(portrait);
		String userId = new Date().getTime()+email.split("@")[0];;
		
		user.setUserId(userId);
		ServiceLocal.getInstance().getUserDao().saveUser(user);
		Status status = new Status();
		status.setCode(200);
		Gson gson = new GsonBuilder().create();
		return gson.toJson(status);
	}
}
