package com.sc.service.impl;

import com.sc.service.BookService;

public class BookServiceImpl implements BookService {

	@Override
	public void buy(String uname, String bname, Double price) {
		// TODO Auto-generated method stub
		System.out.println(uname + "����ͼ�飺" + bname);
		System.out.println("���ѽ�" + price);
		System.out.println("֧���ɹ���������ϵͳ�·�������");
	}

	@Override
	public void comment(String uname, String content) {
		// TODO Auto-generated method stub
		System.out.println(uname + "�������ۣ�" + content);
	}

}
