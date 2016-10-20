package com.jin.auth.android;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jin.com.protobuflib.model.ResultInfo.Result;

import org.apache.commons.codec.binary.Base64;
import org.openid4java.util.HttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.crypt.DES;
import com.crypt.DESUtils;
import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.Output;
import com.google.protobuf.InvalidProtocolBufferException;
import com.proto.demo.PersonInfo;

@Controller
public class ProtobufferControl {
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody byte[] getProtoBuffer(@RequestParam("file") MultipartFile file) {
		
		try {
			byte[] bytes = file.getBytes();
			com.proto.demo.PersonInfo.Person person = PersonInfo.Person.parseFrom(bytes);
			
//			System.out.println(person.toString());
			
			
			File file2 = new File("C:/Users/Administrator/Desktop/newFile/face.jpg");
			if (!file2.exists()) 
				file2.createNewFile();
			FileOutputStream fileOutputStream = new FileOutputStream(file2);
			InputStream inputStream = person.getPhoto(0).getPhoto().newInput();
			
			int length = 0;
			byte[] buffer = new byte[1024];
			
			while ((length = inputStream.read(buffer)) != -1) {
				fileOutputStream.write(buffer, 0, length);
			}
			fileOutputStream.close();
			inputStream.close();
			System.out.println(person.toString());
			 
			
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] byteArray = com.proto.demo.Result.result.newBuilder().setAlertMessage("haod").setResultcode(10).setErrorMessage("cuowu").build().toByteArray();
//		byte[] byteArray = Result.newBuilder().setResultcode(10).setAlertMessage("nizhgegediaomao").setErrorMessage("¥ÌŒÛ–≈œ¢").build().toByteArray();
//		byteArray = DESUtils.DESencrypt(byteArray);
		return byteArray;
	}
}
