package com.sc.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sc.entity.Classes;
import com.sc.entity.Users;
import com.sc.mapper.ClassesMapper;
import com.sc.mapper.UsersMapper;

public class TestOneToOne {

	public static void main(String[] args) throws IOException {
		
		Reader r=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(r);
		SqlSession se=ssf.openSession();
		ClassesMapper mapper=se.getMapper(ClassesMapper.class);
		
		List<Classes> list = mapper.select();
		for (Classes classes : list) {
			System.out.println("班级信息："+classes);
			System.out.println("----该班的老师信息："+classes.getTeacher());
			System.out.println();
		}
		
		se.close();
	}

}
