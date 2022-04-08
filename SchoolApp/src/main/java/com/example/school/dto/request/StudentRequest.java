package com.example.school.dto.request;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.example.school.validation.Email;
import com.example.school.validation.StrongPassword;

public class StudentRequest {
	@Override
	public String toString() {
		return "StudentRequest [name=" + name + ", surname=" + surname + ", email=" + email + ", phone=" + phone
				+ ", username=" + username + ", password=" + password + "]";
	}
	@NotBlank
	@Size(min=2, max=30)
	private String name;
	@NotBlank
	@Size(min=2, max=30)
	private String surname;
	@NotBlank
	@Email(message = "${validation.email}")
	private String email;
	@NotBlank
	@Pattern(regexp ="[0-9\\s]{11}",message = "This is not valid phone number")
	private String phone;
	@NotBlank
	@Size(min=6, max=30)
	private String username;
	@NotBlank
	@StrongPassword
	private String password;
	
	
	public StudentRequest() {
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
