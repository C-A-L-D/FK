package com.sc.service;

import java.util.List;

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

    //��¼
    public Users login(Users u);
}
