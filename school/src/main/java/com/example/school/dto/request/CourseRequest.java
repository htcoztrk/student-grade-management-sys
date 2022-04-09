package com.example.school.dto.request;

import java.util.List;

import javax.validation.constraints.NotBlank;

import com.example.school.entity.CourseType;
import com.example.school.entity.StudentCourse;

public class CourseRequest {
	@NotBlank
	private String code;
	private CourseType courseType;
	List<StudentCourse> studentCourses;
	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}
	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	public CourseRequest() {
		
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
