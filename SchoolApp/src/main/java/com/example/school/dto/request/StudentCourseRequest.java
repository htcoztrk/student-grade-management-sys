package com.example.school.dto.request;

import com.example.school.entity.Course;
import com.example.school.entity.CourseYear;
import com.example.school.entity.Student;

public class StudentCourseRequest {
	private int exam1;
	private int exam2;
	private CourseYear courseYear;
	private Course course;
	private Student student;
	
	public StudentCourseRequest() {
		
	}
	
	public StudentCourseRequest(int exam1, int exam2, CourseYear courseYear, Course course, Student student) {
		this.exam1 = exam1;
		this.exam2 = exam2;
		this.courseYear = courseYear;
		this.course = course;
		this.student = student;
	}

	public int getExam1() {
		return exam1;
	}
	public void setExam1(int exam1) {
		this.exam1 = exam1;
	}
	public int getExam2() {
		return exam2;
	}
	public void setExam2(int exam2) {
		this.exam2 = exam2;
	}
	public CourseYear getCourseYear() {
		return courseYear;
	}
	public void setCourseYear(CourseYear courseYear) {
		this.courseYear = courseYear;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	
}



