package com.sc.test;

import java.util.List;

import com.sc.dao.UsersDao;
import com.sc.entity.Users;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsersDao dao = new UsersDao();
		
		List<Users> list = dao.select();
		for (Users u : list) {
			System.out.println(u);
		}
		
		//�������
		/*Users u = new Users();
		u.setUname("hb123");
		u.setUpass("123");
		dao.add(u);*/
		
		//�����޸�
		/*Users u = dao.get(31);
		System.out.println("ԭ������"+u.getUname());
		u.setUname("hibernate");
		u.setUpass("654321");
		dao.update(u);*/
		
		//����ɾ��
		/*Users u=new Users();
		u.setUid(31);
		dao.delete(u);*/
	}

}
