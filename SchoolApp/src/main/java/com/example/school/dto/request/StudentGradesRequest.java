package com.example.school.dto.request;

import com.example.school.entity.CourseYear;

public class StudentGradesRequest {

	private CourseYear courseYear;
	private String courseCode;
	private Long studentId;
	
	public StudentGradesRequest() {
		
	}
	public CourseYear getCourseYear() {
		return courseYear;
	}
	public void setCourseYear(CourseYear courseYear) {
		this.courseYear = courseYear;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	
}
