package com.sc.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sc.service.ServiceBuy;
import com.sc.service.money.TailMoney;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		TailMoney tm = (TailMoney) app.getBean("money");
		tm.setMoney(100.00);
		
		ServiceBuy ser = (ServiceBuy) app.getBean("serviceBuyImpl");
		tm.setMoney(ser.buy("小舞", "大薯片", 15.50, tm.getMoney()));
		ser.buy("小舞", "口香糖", 100.00, tm.getMoney());
	}

}
