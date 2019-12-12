package com.sc.service;

import com.sc.entity.SysUser;

public interface SysUserService {
	
	//通过用户名查询用户对象
	public SysUser login(String usercode);
	
}
