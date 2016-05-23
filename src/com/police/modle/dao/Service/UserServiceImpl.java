package com.police.modle.dao.Service;

import com.police.modle.User;
import com.police.modle.dao.UserDao;

public class UserServiceImpl implements IUserService {
	private  UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public User getUserId(String username, String password) {
		User user = userDao.login(username, password);
		return user;
	}
	
	public void saveUserId(Long id, String userId) {
		userDao.updateUseToken(id, userId);
	}

}
