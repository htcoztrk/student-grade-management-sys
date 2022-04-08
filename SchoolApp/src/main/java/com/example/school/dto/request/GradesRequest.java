package com.example.school.dto.request;

import com.example.school.entity.CourseYear;

public class GradesRequest {
	private CourseYear courseYear;
	private String courseCode;
	public GradesRequest() {
		
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
	
}
