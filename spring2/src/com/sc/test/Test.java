package com.sc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.service.BookService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService book = (BookService) app.getBean("bookService");
		book.buy("施耐庵", "《三国演义》", 199.99);
		System.out.println();
		book.comment("施耐庵", "《三国演义》写的不错啊！");
	}

}
