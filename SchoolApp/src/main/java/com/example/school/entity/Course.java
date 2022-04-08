package com.example.school.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * 
	 * @Column(name = "identity") private Long identity;
	 */
	@Id
	@Column(name = "code")
	private String code;
	@Column(name = "course_type")
	@Enumerated
	private CourseType courseType;
	// @JsonIgnore
	@OneToMany(mappedBy = "course")
	List<StudentCourse> studentCourses;

	public Course() {
	}

	public Course(String code, CourseType courseType, List<StudentCourse> studentCourses) {
		this.code = code;
		this.courseType = courseType;
		this.studentCourses = studentCourses;
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

	@Override
	public int hashCode() {
		return Objects.hash(code);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return Objects.equals(code, other.code);
	}

	@Override
	public String toString() {
		return "Course [code=" + code + ", courseType=" + courseType + "]";
	}

	public Course(Builder builder) {
		this.code = builder.code;
		this.courseType = builder.courseType;
	}

	public static class Builder {
		private String code;
		private CourseType courseType;

		public Builder() {

		}

		public Builder code(String code) {
			this.code = code;
			return this;
		}

		public Builder courseType(CourseType courseType) {
			this.courseType = courseType;
			return this;
		}

		public Course build() {
			return new Course(this);
		}
	}
}
