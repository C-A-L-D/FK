package com.sc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sc.entity.Users;

public class UsersDao {

	public void add(Users u) {
		//1��ȡ�Ự�������Ӷ���
		Session session = HibernateSessionFactory.getSession();
		//2��ʼ����
		Transaction tx = session.beginTransaction();
		//3����ʵ�����
		session.save(u);
		//4�ύ���� 
		tx.commit();
		//5�رջỰ
		session.close();
	}
	
	public void update(Users u) {
		//1��ȡ�Ự�������Ӷ���
		Session session = HibernateSessionFactory.getSession();
		//2��ʼ����
		Transaction tx = session.beginTransaction();
		//3�޸�ʵ�����
		session.update(u);
		//4�ύ���� 
		tx.commit();
		//5�رջỰ
		session.close();
	}
	
	public void del(Users u) {
		//1��ȡ�Ự�������Ӷ���
		Session session = HibernateSessionFactory.getSession();
		//2��ʼ����
		Transaction tx = session.beginTransaction();
		//3ɾ��ʵ�����
		session.delete(u);
		//4�ύ���� 
		tx.commit();
		//5�رջỰ
		session.close();
	}
	
	public Users get(Integer uid) {
		//1��ȡ�Ự�������Ӷ���
		Session session = HibernateSessionFactory.getSession();
		//2ͨ��ID��ȡ����ֻ��ͨ��������ȡ��
		Users u = session.get(Users.class, uid);
		//3�رջỰ
		session.close();
		return u;
	}
	
	//��ѯ
	public List<Users> select() {
		//1��ȡ�Ự�������Ӷ���
		Session session = HibernateSessionFactory.getSession();
		//2��ѯ���
		String hql = "from Users";
		//3������ѯ����
		Query query = session.createQuery(hql);
		//4��ȡ���
		List<Users> list = query.list();
		//5�رջỰ
		session.close();
		
		return list;
	}
}
