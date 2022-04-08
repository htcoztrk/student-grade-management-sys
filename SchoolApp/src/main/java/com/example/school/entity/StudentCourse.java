package com.example.school.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="student_course")
public class StudentCourse {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "identity")
	private Long identity;
	@Column(name="exam1")
	private int exam1;
	@Column(name="exam2")
	private int exam2;
	private CourseYear courseYear;
	@ManyToOne
	@JoinColumn(name="course_id")
	private Course course;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="student_id")
	private Student student;
	public StudentCourse() {

	}
	public StudentCourse(Long identity, int exam1, int exam2, CourseYear courseYear, Course course, Student student) {
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
		this.identity = identity;
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
		StudentCourse other = (StudentCourse) obj;
		return Objects.equals(identity, other.identity);
	}
	@Override
	public String toString() {
		return "StudentCourse [identity=" + identity + ", exam1=" + exam1 + ", exam2=" + exam2 + ", courseYear="
				+ courseYear + ", course=" + course + ", student=" + student + "]";
	}
	
}
