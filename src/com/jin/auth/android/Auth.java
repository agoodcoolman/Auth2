package com.jin.auth.android;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/auth.do")
public class Auth {

	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String AuthAndroid(@RequestParam("deviceID")String deviceID
			, @RequestParam("username")String username) {
		String message = "Hello World, Spring MVC!";
        return message+ deviceID;
	}
}
