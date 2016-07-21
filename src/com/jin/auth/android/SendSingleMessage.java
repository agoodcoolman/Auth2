package com.jin.auth.android;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.rong.ApiHttpClient;
import io.rong.Constants;
import io.rong.models.FormatType;
import io.rong.models.SdkHttpResult;
import io.rong.models.TxtMessage;
import io.rong.util.GsonUtil;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jin.auth.android.modle.User;

@Controller
public class SendSingleMessage {
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public void sendSingleTxtmessage (@RequestBody User user) {
		List<String> toIds = new ArrayList<String>();
		TxtMessage txtMessage = new TxtMessage(user.getContent());
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", user.getId());
		map.put("status", "0");
		map.put("caseInfo", user.getContent());
		map.put("date", new Date().getTime()+"");
		map.put("caseName", "普通案件");
		map.put("callNo", "15629976793");
		map.put("reportName", "张欢");
		map.put("fkdbh", user.getFkdh());
		txtMessage.setExtra(GsonUtil.toJson(map, Map.class));
		toIds.add(user.getUsername());
		SdkHttpResult result;
		try {
			result = ApiHttpClient.publishMessage(Constants.key, Constants.secret, "fromUserId", toIds,
					txtMessage, FormatType.json);
			
			System.out.println("txtMessage="+ txtMessage +"publishMessage=" + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
