package com.sc.entity;

import java.util.List;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */

public class Student implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", stuName=" + stuName + ", classesId=" + classesId + "]";
	}

	private Integer stuId;
	private String stuName;
	private Integer classesId;

	private List<Course> course;
	
	// Constructors

	/** default constructor */
	public Student() {
	}

	public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	/** full constructor */
	public Student(String stuName, Integer classesId) {
		this.stuName = stuName;
		this.classesId = classesId;
	}

	// Property accessors

	public Integer getStuId() {
		return this.stuId;
	}

	public void setStuId(Integer stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return this.stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public Integer getClassesId() {
		return this.classesId;
	}

	public void setClassesId(Integer classesId) {
		this.classesId = classesId;
	}

}