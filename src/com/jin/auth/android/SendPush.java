package com.jin.auth.android;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.Part;

import io.rong.ApiHttpClient;
import io.rong.models.FormatType;
import io.rong.models.MsgObj;
import io.rong.models.PlatformNotification;
import io.rong.models.PushMessage;
import io.rong.models.PushNotification;
import io.rong.models.SdkHttpResult;
import io.rong.models.TagObj;
import io.rong.Constants;

import org.eclipse.persistence.annotations.Mutable;
import org.springframework.faces.webflow.context.portlet.RequestParameterMap;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.google.protobuf.ByteString;

@Controller

public class SendPush {
	
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	
	//  @RequestParam("name") String name,@RequestParam("file") MultipartFile[] file
//	public String sendPush(ModelMap model, @RequestBody String stream, Writer writer) throws Exception {
		public @ResponseBody String sendPush() throws Exception {

//		model.addAttribute("message", "sucess");
		PushMessage message = createPushMessage();//������Ϣ
		//PushMessage message = createPushMessage2();//�����push
		SdkHttpResult result = ApiHttpClient.push(Constants.key, Constants.secret, message, FormatType.json);
		System.out.println("push=" + result);
		//���û����ǩ
//		UserTag tag = new UserTag();
//		tag.setTags(new String[] { "a", "b" });
//		tag.setUserId("1463369731739deao3");
//		result = ApiHttpClient.setUserTag(Constants.key, Constants.secret, tag, FormatType.json);
		System.out.println("tag=" + result);
		return "hello";
	}
	
	/**
	 * �������������Ϣ������
	 */
	private PushMessage createPushMessage()
			throws UnsupportedEncodingException {
		List<String> osList = new ArrayList<String>();
//		osList.add("ios");
		osList.add("android");

		TagObj tag = new TagObj();
		tag.setIs_to_all(false);//��ȫ���û��� ����Ϊtrue�������ǩ��userids����Ч
		
//		//�����ǩ�ķ������ñ�ǩ
//		List<String> tagas = new ArrayList<String>();
//		tagas.add("a");
//		tagas.add("b");
//		tagas.add("3");
//		tag.setTag(tagas);
//		
//		//���ض��û�ID��,���ȼ���������ı�ǩ
		List<String> tagus = new ArrayList<String>();
//		tagus.add("1463369731739deao3");
		tagus.add("police001");
	
		tag.setUserid(tagus);
		
		PushMessage pmsg = new PushMessage();
		pmsg.setPlatform(osList);
		PushNotification noti = new PushNotification();
		noti.setAlert("�ǲ��Ǻܰ�");
		noti.setAndroid(createPush("�з�ͬ��Ʒ������"));
//		noti.setIos(createPush("Ios�ǲ��Ǻܰ�"));
//		noti.setIos(createPush());
		pmsg.setNotification(noti);
		
		//������������������ ���Ʒ��͵������Ϣ���ǲ���ص�push
		//PushMessageʵ���е� fromuserid �� messageΪnull��Ϊ����ص�push
//		pmsg.setFromuserid("fromuseId1");
		/*MsgObj msg = new MsgObj();
		TxtMessage message = new TxtMessage("hello", "one extra");
		msg.setContent(message.toString());
		msg.setObjectName(message.getType());
		pmsg.setMessage(msg);*/
		//������������������ ���Ʒ��͵������Ϣ���ǲ���ص�push
		
		pmsg.setAudience(tag);
		System.out.println(pmsg.toString());
		return pmsg;
	}
	
	private static PlatformNotification createPush(String content) {
		PlatformNotification data = new PlatformNotification();
		//  {"id":"8F95EEE362DF4F70AD7B7F2F8E581A27","status":0,"caseInfo":"�з�ͬ��Ʒ�","date":null,"caseName":"��ͨ����"}
		data.setAlert(content);
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "6F95EEE362DF4F70AD7B7F2F8E581A27");
		map.put("status", "0");
		map.put("caseInfo", "�з�ͬ��Ʒ�");
		map.put("date", new Date().getTime()+"");
		map.put("caseName", "��ͨ����");
		map.put("callNo", "15629976793");
		map.put("reportName", "��ĳ");
		data.setExtras(map);
		return data;
	}
	
}
