package com.example.school.dto.response;

import com.example.school.entity.CourseType;

public class CourseResponse {
	private String code;
	private CourseType courseType;
	
	

	public CourseResponse() {

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public CourseType getCourseType() {
		return courseType;
	}

	public void setCourseType(CourseType courseType) {
		this.courseType = courseType;
	}

}
