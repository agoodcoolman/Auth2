package com.jin.auth.android.modle;


import java.io.Serializable;



/**
 * Entity mapped to table USER.
 */

public class UserAndroidAPI implements Serializable {

    private String userId;

    private String passwd;

    private int code;
    
    private String message;
   
    private String token;
    
    private String username;
    
    private String portrait;
    
    

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPortrait() {
		return portrait;
	}

	public void setPortrait(String portrait) {
		this.portrait = portrait;
	}

	public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public UserAndroidAPI() {

    }

    public String getUserId() {

        return userId;

    }

    public void setUserId(String userId) {

        this.userId = userId;

    }


    public String getPasswd() {

        return passwd;

    }

    public void setPasswd(String passwd) {

        this.passwd = passwd;

    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}