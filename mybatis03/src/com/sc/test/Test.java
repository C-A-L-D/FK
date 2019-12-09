package com.sc.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sc.entity.Users;
import com.sc.mapper.UsersMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		
		Reader r=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(r);
		SqlSession se=ssf.openSession();
		UsersMapper mapper=se.getMapper(UsersMapper.class);
		
		//�����޸�
		 /*Users users2 = mapper.get(32);
		 System.out.println("32��ԭ���ǣ�"+users2.getUname());
		 users2.setUname("����123");
		 users2.setUpass("999");
		 mapper.update(users2);*/
		
		//�������
		Users u1=new Users();
		u1.setUname("����uid111");
		System.out.println("���ǰuid��"+u1.getUid());
		mapper.add(u1);
		System.out.println("��Ӻ�uid��"+u1.getUid());
		
		//1�����Բ�ѯ
		List<Users> list = mapper.select();
		for (Users users : list) {
			System.out.println(users);
		}
		System.out.println("�����ɹ���");
		se.commit();//�ύ����
		
		se.close();
	}

}
