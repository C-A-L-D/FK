package com.sc.mapper;

import java.util.List;

import com.sc.entity.Users;

public interface UsersMapper {
	
	//添加
	public void add(Users u);
	
	//修改
    public void update(Users u);
    
    //删除
    public void delete(Users u);
    
    //获取对象
    public Users get(Integer uid);
    
    //查询
    public List<Users> select();
    
    //登录
    public List<Users> login(Users u);

}
