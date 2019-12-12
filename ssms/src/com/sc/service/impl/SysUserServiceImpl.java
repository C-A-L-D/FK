package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sc.entity.SysUser;
import com.sc.entity.SysUserExample;
import com.sc.entity.SysUserExample.Criteria;
import com.sc.mapper.SysUserMapper;
import com.sc.service.SysUserService;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	//依赖注入
	@Autowired
	SysUserMapper sysUserMapper;

	//通过用户名查询用户对象
	@Override
	public SysUser login(String usercode) {
		
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsercodeEqualTo(usercode);//设置用户名的条件
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
