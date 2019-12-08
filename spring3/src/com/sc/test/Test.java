package com.sc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.dao.UsersDao;
import com.sc.entity.Users;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		UsersDao usersDao = (UsersDao) app.getBean("usersDao");
		//≤‚ ‘≤È—Ø
		List<Users> list = usersDao.select();
		for (Users u : list) {
			System.out.println(u);
			u.setSex("ƒ–");
			usersDao.update(u);
		}
		
	}

}
