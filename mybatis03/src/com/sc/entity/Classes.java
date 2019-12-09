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

	//һ��һ����start
	private Teacher teacher;//��һ��һ������������һ�Ķ���

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	//һ��һ����end
	
	//һ�Զ�����start
	private List<Student> students;//��һ��һ�������������ļ���
	
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	//һ�Զ�����end
	
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