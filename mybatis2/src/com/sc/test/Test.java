package com.sc.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Scanner;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.sc.entity.Course;
import com.sc.entity.Student;
import com.sc.mapper.ClassesMapper;
import com.sc.mapper.StudentMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Reader r = Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory ssfb = new SqlSessionFactoryBuilder().build(r);
		SqlSession ss = ssfb.openSession();
		/*ClassesMapper mapper = ss.getMapper(ClassesMapper.class);*/
		
		/*List<Classes> list = mapper.select();
		for (Classes classes : list) {
			System.out.println("�༶��Ϣ��"+classes);
			System.out.println("-----�ð����ʦ��Ϣ��"+classes.getTeacher());
		}
		*/
		
		/*List<Student> list2;
		List<Classes> list = mapper.select1();
		for (Classes classes : list) {
			System.out.println("�༶��Ϣ��"+classes);
			System.out.println("-----�ð����ʦ��Ϣ��");
			list2 = classes.getStudent();
			for (Student student : list2) {
				System.out.println(student);
			}
		}*/
		
		List<Student> list;
		StudentMapper mapper = ss.getMapper(StudentMapper.class);
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.println("please choose a number:1(ѧ��������) or 2(�γ�������)");
			String n = scan.next();
			if(n.equals("1")){
				System.out.println("������ѧ��������");
				list = mapper.select(scan.next(),"");
				if (list == null || list.size() <= 0) {
					System.out.println("�����鲻���κ���Ϣ.....");
				}
				for (Student s : list) {
					List<Course> course = s.getCourse();
					for (Course c : course) {
						System.out.println("��ѧ��ȫ����Ϣ��" + s + "\t" + c);
					}
				}
			}
			if(n.equals("2")){
				System.out.println("������γ�������");
				list = mapper.select("", scan.next());
				if (list == null || list.size() <= 0) {
					System.out.println("�����鲻���κ���Ϣ.....");
				}
				for (Student s : list) {
					List<Course> course = s.getCourse();
					for (Course c : course) {
						System.out.println("�ÿγ�ȫ����Ϣ��" + s + "\t" + c);
					}
				}
			}
		}
		
	}

}
