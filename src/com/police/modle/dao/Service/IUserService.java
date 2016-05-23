package com.police.modle.dao.Service;

import com.police.modle.User;

public interface IUserService {
	
	public User getUserId(String username, String password);
	
	public void saveUserId(Long id, String userId);
}
