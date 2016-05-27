package com.jin.auth.android.modle;

import org.springframework.web.bind.annotation.RequestBody;

public class User {
	
	private String  username;
	private String content;
	private String id;
	private String fkdh;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFkdh() {
		return fkdh;
	}
	public void setFkdh(String fkdh) {
		this.fkdh = fkdh;
	}
	
	
	
}
