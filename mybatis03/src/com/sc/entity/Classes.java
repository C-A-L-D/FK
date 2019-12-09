package com.sc.entity;

import java.util.List;

/**
 * Classes entity. @author MyEclipse Persistence Tools
 */

public class Classes implements java.io.Serializable {

	// Fields

	private Integer classesId;
	private String classesName;
	private String classesInfo;
	private Integer teacherId;

	//一对一配置start
	private Teacher teacher;//在一的一方，定义另外一的对象

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	//一对一配置end
	
	//一对多配置start
	private List<Student> students;//在一的一方，配置另外多的集合
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//一对多配置end
	
	// Constructors


	/** default constructor */
	public Classes() {
	}

	/** full constructor */
	public Classes(String classesName, String classesInfo, Integer teacherId) {
		this.classesName = classesName;
		this.classesInfo = classesInfo;
		this.teacherId = teacherId;
	}

	// Property accessors

	public Integer getClassesId() {
		return this.classesId;
	}

	public void setClassesId(Integer classesId) {
		this.classesId = classesId;
	}

	public String getClassesName() {
		return this.classesName;
	}

	public void setClassesName(String classesName) {
		this.classesName = classesName;
	}

	public String getClassesInfo() {
		return this.classesInfo;
	}

	public void setClassesInfo(String classesInfo) {
		this.classesInfo = classesInfo;
	}

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		return "Classes [classesId=" + classesId + ", classesName=" + classesName + ", classesInfo=" + classesInfo
				+ ", teacherId=" + teacherId + "]";
	}

}