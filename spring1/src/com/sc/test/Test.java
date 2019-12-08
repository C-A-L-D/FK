package com.sc.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.bean.HelloBean;
import com.sc.print.Printer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//读取配置文件applicationContext.xml
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从容器取出bean对象
		HelloBean h = (HelloBean) app.getBean("helloBean");
		System.out.println(h.getHelloWorld());
		
		System.out.println(h.getMyList());
		System.out.println(h.getMyPro());
		
		////////////////////////////////
		Printer p = (Printer) app.getBean("printer");
		p.print();
	}

}
