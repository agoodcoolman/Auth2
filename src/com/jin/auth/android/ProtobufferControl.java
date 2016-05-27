package com.jin.auth.android;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.tutorial.AddressBookProtos.AddressBook;
import com.google.protobuf.InvalidProtocolBufferException;

@Controller
public class ProtobufferControl {
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String getProtoBuffer(@RequestParam("file") MultipartFile file) {
		AddressBook parseFrom;
		try {
			parseFrom = AddressBook.parseFrom(file.getBytes());
			System.out.println(parseFrom.toString());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "³É¹¦";
	}
}
