package com.jin.auth.android;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginCookieControl {

	@RequestMapping(method = {RequestMethod.POST})
	public @ResponseBody byte[] setCookie(@RequestParam(value="username") String username
			,HttpServletResponse response) {
		Cookie cookie = new Cookie("cookie", "djeofheoheofw");
		response.addCookie(cookie);
		
		byte[] a = new byte[1024];
		
		try {
			new RandomAccessFile(new File(""), "r");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
}
