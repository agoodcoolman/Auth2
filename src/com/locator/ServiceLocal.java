package com.locator;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.police.modle.dao.UserDao;


public class ServiceLocal {
	private static ServiceLocal instance;
	private ClassPathXmlApplicationContext context;
	
	public static ServiceLocal getInstance() {
        // return instance;
        if (instance == null) {
            synchronized (ServiceLocal.class) {
                instance = new ServiceLocal();
            }
        }
        return instance;
    }

	public ServiceLocal() {
		if (instance != null) 
			throw new IllegalArgumentException("has initstance");
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	public UserDao getUserDao() {
		return (UserDao)context.getBean("userDao");
	}
	
	
}
