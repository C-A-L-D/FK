package com.sc.entity;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public class Teacher implements java.io.Serializable {

	// Fields

	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", teacherName=" + teacherName + ", teacherNumber=" + teacherNumber
				+ ", teacherAge=" + teacherAge + "]";
	}

	private Integer teacherId;
	private String teacherName;
	private String teacherNumber;
	private Integer teacherAge;

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** full constructor */
	public Teacher(String teacherName, String teacherNumber, Integer teacherAge) {
		this.teacherName = teacherName;
		this.teacherNumber = teacherNumber;
		this.teacherAge = teacherAge;
	}

	// Property accessors

	public Integer getTeacherId() {
		return this.teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherNumber() {
		return this.teacherNumber;
	}

	public void setTeacherNumber(String teacherNumber) {
		this.teacherNumber = teacherNumber;
	}

	public Integer getTeacherAge() {
		return this.teacherAge;
	}

	public void setTeacherAge(Integer teacherAge) {
		this.teacherAge = teacherAge;
	}

}