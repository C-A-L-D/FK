package com.sc.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import com.github.pagehelper.PageInfo;
import com.sc.entity.Users;

public interface UsersService {
	//���
	public void add(Users u);
	
	//�޸�
    public void update(Users u);
    
    //ɾ��
    public void delete(Users u);
    
    //��ȡ����
    public Users get(Integer uid);
    
    //��ѯ
    public List<Users> select();
    
    //��ҳ��ѯ
    public PageInfo<Users> selectPage(Integer pageNum, Integer pageSize);

    //��¼
    public Users login(Users u);
}
