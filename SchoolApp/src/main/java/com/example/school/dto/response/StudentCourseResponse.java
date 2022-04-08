package com.example.school.dto.response;

import java.util.Objects;

import com.example.school.entity.Course;
import com.example.school.entity.CourseYear;
import com.example.school.entity.Student;

public class StudentCourseResponse {
	private Long identity;
	private int exam1;
	private int exam2;
	private CourseYear courseYear;
	private Course course;
	private Student student;
	public StudentCourseResponse() {
		
	}
	
	public StudentCourseResponse(Long identity, int exam1, int exam2, CourseYear courseYear, Course course,
			Student student) {
		this.identity = identity;
		this.exam1 = exam1;
		this.exam2 = exam2;
		this.courseYear = courseYear;
		this.course = course;
		this.student = student;
	}

	public Long getIdentity() {
		return identity;
	}
	public void setIdentity(Long identity) {
		this.identity= identity;
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
	@Override
	public int hashCode() {
		return Objects.hash(identity);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentCourseResponse other = (StudentCourseResponse) obj;
		return Objects.equals(identity, other.identity);
	}
}
