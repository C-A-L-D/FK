package com.sc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.entity.Student;

public interface StudentMapper {

	public List<Student> select(@Param("stuName")String stuName, @Param("courseName")String courseName);
}
