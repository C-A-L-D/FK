package com.sc.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate4.HibernateTemplate;
import com.sc.dao.UsersDao;
import com.sc.entity.Users;

public class UsersDaoImpl implements UsersDao {

	//我们自己的dao类依赖于hibernate模板对象
	HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
					//默认是，可读写，需要事务
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
