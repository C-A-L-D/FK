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

	private Teacher teacher;//��һ��һ����������һ�Ķ���(һ��һ������)
	
	private List<Student> student;//��һ��һ�����������ļ��ϣ�һ�Զ����ã�
	// Constructors

	public Teacher getTeacher() {
		return teacher;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

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