package com.sc.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.github.pagehelper.PageInfo;
import com.sc.entity.Users;

public interface UsersService {
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
    
    //分页查询
    public PageInfo<Users> selectPage(Integer pageNum, Integer pageSize);

    //登录
    public Users login(Users u);
}
