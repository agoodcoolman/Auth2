package com.police.modle.dao;

import com.police.modle.User;

public interface UserDao {

	public User getUser(String userid);
	
	public void saveUser(User user);
	
	public User login(String email, String password);
	
	public void updateUseToken(Long id, String token);
}
