package com.sc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.service.BookService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService book = (BookService) app.getBean("bookService");
		book.buy("ʩ����", "���������塷", 199.99);
		System.out.println();
		book.comment("ʩ����", "���������塷д�Ĳ�����");
	}

}
