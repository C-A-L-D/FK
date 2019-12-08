package com.sc.dao;

import java.util.List;

import com.sc.entity.Users;

public interface UsersDao {

	public void add(Users u);
	
	public void update(Users u);
	
	public void del(Users u);
	
	public Users get(Integer uid);
	
	public List<Users> select();
}
