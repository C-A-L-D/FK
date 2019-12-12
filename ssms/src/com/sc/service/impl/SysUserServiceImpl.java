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
	
	//����ע��
	@Autowired
	SysUserMapper sysUserMapper;

	//ͨ���û�����ѯ�û�����
	@Override
	public SysUser login(String usercode) {
		
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsercodeEqualTo(usercode);//�����û���������
		List<SysUser> list = sysUserMapper.selectByExample(example);
		if(list!=null&&list.size()>0){
			return list.get(0);
		}
		return null;
	}

}
