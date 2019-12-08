package com.sc.service.impl;

import com.sc.service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public void buy(String uname, String bname, Double price) {
		// TODO Auto-generated method stub
		System.out.println(uname + "购买图书：" + bname);
		System.out.println("消费金额：" + price);
		System.out.println("支付成功！向物流系统下发货单！");
	}

	@Override
	public void comment(String uname, String content) {
		// TODO Auto-generated method stub
		System.out.println(uname + "发表评论：" + content);
	}

}
