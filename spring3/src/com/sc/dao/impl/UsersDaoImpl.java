package com.sc.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import com.sc.dao.UsersDao;
import com.sc.entity.Users;

public class UsersDaoImpl implements UsersDao {

	//�����Լ���dao��������hibernateģ�����
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
					//Ĭ���ǣ��ɶ�д����Ҫ����
	//@Transactional(readOnly=false, propagation=Propagation.REQUIRED)
	@Override
	public void add(Users u) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(u);
	}

	@Override
	public void update(Users u) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(u);
	}

	@Override
	public void del(Users u) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.delete(u);
	}

	@Override
	public Users get(Integer uid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Users.class, uid);
	}

	@Override
	public List<Users> select() {
		// TODO Auto-generated method stub
		return (List<Users>) this.hibernateTemplate.find("from Users");
	}
	
	
}
