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

public class TestSQL2 {

	public static void main(String[] args) throws IOException {
		
		Reader r=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(r);
		
		System.out.println("��һ�β�ѯ");
		SqlSession se=ssf.openSession();
		StudentMapper mapper=se.getMapper(StudentMapper.class);
		
		Student stu=new Student();
		//stu.setStuName("��");
		//stu.setNames(new String[]{"����","С��","���»�"});
		List<Student> students = mapper.getStudents(stu);
		for (Student student : students) {
			System.out.println(student);
		}
		
		se.close();
		
		System.out.println("�ڶ��β�ѯ");
		SqlSession se1=ssf.openSession();
		StudentMapper mapper1=se1.getMapper(StudentMapper.class);
		
		Student stu1=new Student();
		//stu.setStuName("��");
		//stu1.setNames(new String[]{"����","С��","���»�"});
		List<Student> students1 = mapper1.getStudents(stu1);
		for (Student student1 : students1) {
			System.out.println(student1);
		}
		
		se1.close();
		
	}

}
