package com.jin.auth.android;

import java.lang.reflect.Type;
import java.util.LinkedHashMap;
import java.util.Map;

import io.rong.ApiHttpClient;
import io.rong.Constants;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import io.rong.util.GsonUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.locator.ServiceLocal;
import com.police.modle.User;
import com.police.modle.dao.UserDao;
import com.police.modle.dao.Service.UserServiceImpl;

@Controller
public class LoginControll {
	
	@RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String loginGetUserId(@RequestParam(value="email")String email,
			@RequestParam(value="password")String password) {
		
		SdkHttpResult token = null;
		UserDao userDao = ServiceLocal.getInstance().getUserDao();
		User user = userDao.login(email, password);
		if (user == null ||user.getUserId() ==null) {
			com.jin.auth.android.modle.UserAndroidAPI user2 = new com.jin.auth.android.modle.UserAndroidAPI();
			user2.setCode(401);
			
			Gson json = new Gson();
			return json.toJson(user2);
		}
		try {
			 token = ApiHttpClient.getToken(Constants.key, Constants.secret, user.getUserId(), email,
					"http://aa.com/a.png", FormatType.json);
			 
			 final Map<String, Object> map = new LinkedHashMap<String, Object>(); 
			 Type type = new TypeToken<Map<String, Object>>(){}.getType();
			 Map<String, Object> fromJson =(Map<String, Object>) GsonUtil.fromJson(token.getResult(), type);
			 ServiceLocal.getInstance().getUserDao().updateUseToken(user.getId(), (String)fromJson.get("token"));
			 
			 user.setToken((String)fromJson.get("token"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		com.jin.auth.android.modle.UserAndroidAPI user2 = new com.jin.auth.android.modle.UserAndroidAPI();
		user2.setCode(200);
		user2.setUserId(user.getUserId());
		user2.setToken(user.getToken());
		user2.setUserId(user.getUserId());
		user2.setUsername(user.getUsername());
		user2.setPortrait("http://aa.com/a.png");
		Gson json = new Gson();
		return json.toJson(user2);
	}
	
}
