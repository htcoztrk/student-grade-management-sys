package com.example.school.dto.response;

import java.util.List;

import com.example.school.entity.CourseType;
import com.example.school.entity.StudentCourse;

public class CourseResponse {
	private String code;
	private CourseType courseType;
	List<StudentCourse> studentCourses;
	public List<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(List<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

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
