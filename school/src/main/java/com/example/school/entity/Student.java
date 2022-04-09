package com.example.school.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.school.validation.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long identity;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	//@StrongPassword
	private String password;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "email")
	@Email
	private String email;
	@Column(name = "phone")
	private String phone;
	@JsonIgnore
	@OneToMany(mappedBy = "student",fetch=FetchType.LAZY)
	List<StudentCourse> studentCourses;

	public Student() {

	}
	public Student(Long identity, String username, String password, String name, String surname, String email,
			String phone, List<StudentCourse> studentCourses) {
		super();
		this.identity = identity;
		this.username = username;
		this.password = password;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.phone = phone;
		this.studentCourses = studentCourses;
	}
	public void setIdentity(Long identity) {
		this.identity = identity;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public Long getIdentity() {
		return identity;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Student(Builder builder) {
		this.identity = builder.identity;
		this.name = builder.name;
		this.surname = builder.surname;
		this.email = builder.email;
		this.phone = builder.phone;
		this.username = builder.username;
		this.password=builder.password;
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
		Student other = (Student) obj;
		return Objects.equals(identity, other.identity);
	}


	@Override
	public String toString() {
		return "Student [identity=" + identity + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", phone=" + phone + "]";
	}


	public static class Builder {
		private Long identity;
		private String name;
		private String surname;
		private String email;
		private String phone;
		private String username;
		private String password;

		public Builder() {

		}

		public Builder identity(Long identity) {
			this.identity = identity;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder surname(String surname) {
			this.surname = surname;
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder username(String username) {
			this.username = username;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public Student build() {
			return new Student(this);
		}
	}

}
