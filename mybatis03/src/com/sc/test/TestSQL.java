package com.sc.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sc.entity.Student;
import com.sc.entity.Users;
import com.sc.mapper.StudentMapper;
import com.sc.mapper.UsersMapper;

public class TestSQL {

	public static void main(String[] args) throws IOException {
		
		Reader r=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(r);
		SqlSession se=ssf.openSession();
		StudentMapper mapper=se.getMapper(StudentMapper.class);
		
		Student stu=new Student();
		//stu.setStuName("张");
		stu.setNames(new String[]{"赵六","小李","刘德华"});
		System.out.println("第一次查询：");
		List<Student> students = mapper.getStudents(stu);
		for (Student student : students) {
			System.out.println(student);
		}
		
		System.out.println("第二次查询：");
		List<Student> students1 = mapper.getStudents(stu);
		for (Student student1 : students1) {
			System.out.println(student1);
		}
		
		se.close();
	}

}
