package com.sc.service.impl;

import com.sc.service.ServiceBuy;

public class ServiceBuyImpl implements ServiceBuy {

	@Override
	public Double buy(String uname, String food, Double price, Double money) {
		// TODO Auto-generated method stub
		money -= price;
		System.out.println(uname + "����һ��" + food + "������" + price);
		return money;
	}

	@Override
	public void noBuy(String uname) {
		// TODO Auto-generated method stub
		System.out.println(uname + "�����˹��");
	}

}
