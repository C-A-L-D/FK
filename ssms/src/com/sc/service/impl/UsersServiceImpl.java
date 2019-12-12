package com.sc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.entity.Users;
import com.sc.entity.UsersExample;
import com.sc.entity.UsersExample.Criteria;
import com.sc.mapper.UsersMapper;
import com.sc.service.UsersService;
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersMapper usersMapper;

	@Override
	public void add(Users u) {
		if(u!=null){
		  this.usersMapper.insert(u);
		}
	}

	@Override
	public void update(Users u) {
		if(u!=null&&u.getUid()!=null){
			this.usersMapper.updateByPrimaryKey(u);
		}
	}

	@Override
	public void delete(Users u) {
		if(u!=null){
			this.usersMapper.deleteByPrimaryKey(u.getUid());
		}
	}

	@Override
	public Users get(Integer uid) {
		if(uid!=null){
		   return this.usersMapper.selectByPrimaryKey(uid);
		}
		return null;
	}

	@Override
	public List<Users> select() {
		return this.usersMapper.selectByExample(null);
	}

	@Override
	public Users login(Users u) {
		
		if(u!=null&&u.getUname()!=null&&u.getUpass()!=null){
			UsersExample example=new UsersExample();
			Criteria criteria = example.createCriteria();//设置条件的对象
			criteria.andUnameEqualTo(u.getUname());//设置用户名等于的条件
			//criteria.andUnameLike("%"+u.getUname()+"%");//用户名模糊查询
			criteria.andUpassEqualTo(u.getUpass());//设置密码等于的条件
			
			List<Users> list = this.usersMapper.selectByExample(example);
			if(list!=null&&list.size()>0){
				return list.get(0);
			}
		}
		
		return null;
	}

	@Override
	public PageInfo<Users> selectpage(Integer pageNum, Integer pageSize) {
		//设置分页数据，开始分页
		PageHelper.startPage(pageNum, pageSize);
		//查询当前页的集合数据
		List<Users> list = this.usersMapper.selectByExample(null);
		//封装成pageinfo对象
		PageInfo<Users> page=new PageInfo<Users>(list);
		
		return page;
	}

}
