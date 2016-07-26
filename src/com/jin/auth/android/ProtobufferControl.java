package com.jin.auth.android;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jin.com.protobuflib.model.AddressBookProtos.AddressBook;
import jin.com.protobuflib.model.AddressBookProtos.Person;
import jin.com.protobuflib.model.ResultInfo.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.protobuf.ByteString;
import com.google.protobuf.ByteString.Output;
import com.google.protobuf.InvalidProtocolBufferException;

@Controller
public class ProtobufferControl {
	@RequestMapping(method = {RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody byte[] getProtoBuffer(@RequestParam("file") MultipartFile file) {
		AddressBook parseFrom;
		Person person;
		
		try {
			person = Person.parseFrom(file.getBytes());
//			parseFrom = AddressBook.parseFrom();
//			person = Person.parseFrom(file.getBytes());
//			File file2 = new File("C:/Users/Administrator/Desktop/newFile/face.jpg");
//			if (!file2.exists()) 
//				file2.createNewFile();
//			FileOutputStream fileOutputStream = new FileOutputStream(file2);
			
//			InputStream inputStream = person.getPhotoList().get(0).getPhoto().newInput();
//			int length = 0;
//			byte[] buffer = new byte[1024];
			
//			while ((length = inputStream.read(buffer)) != -1) {
//				fileOutputStream.write(buffer, 0, length);
//			}
//			fileOutputStream.close();
//			inputStream.close();
//			System.out.println(person.toString());
			 
			
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] byteArray = Result.newBuilder().setResultcode(10).build().toByteArray();
		
		return byteArray;
	}
}
