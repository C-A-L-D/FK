package com.sc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sc.entity.Users;

public class UsersDao {

	public void add(Users u) {
		//1获取会话对象（连接对象）
		Session session = HibernateSessionFactory.getSession();
		//2开始事务
		Transaction tx = session.beginTransaction();
		//3保存实体对象
		session.save(u);
		//4提交事务 
		tx.commit();
		//5关闭会话
		session.close();
	}
	
	public void update(Users u) {
		//1获取会话对象（连接对象）
		Session session = HibernateSessionFactory.getSession();
		//2开始事务
		Transaction tx = session.beginTransaction();
		//3修改实体对象
		session.update(u);
		//4提交事务 
		tx.commit();
		//5关闭会话
		session.close();
	}
	
	public void del(Users u) {
		//1获取会话对象（连接对象）
		Session session = HibernateSessionFactory.getSession();
		//2开始事务
		Transaction tx = session.beginTransaction();
		//3删除实体对象
		session.delete(u);
		//4提交事务 
		tx.commit();
		//5关闭会话
		session.close();
	}
	
	public Users get(Integer uid) {
		//1获取会话对象（连接对象）
		Session session = HibernateSessionFactory.getSession();
		//2通过ID获取对象（只能通过主键获取）
		Users u = session.get(Users.class, uid);
		//3关闭会话
		session.close();
		return u;
	}
	
	//查询
	public List<Users> select() {
		//1获取会话对象（连接对象）
		Session session = HibernateSessionFactory.getSession();
		//2查询语句
		String hql = "from Users";
		//3创建查询对象
		Query query = session.createQuery(hql);
		//4获取结果
		List<Users> list = query.list();
		//5关闭会话
		session.close();
		
		return list;
	}
}
