package com.example.school.dto.response;

public class StudentResponse {
	private Long identity;
	private String name;
	private String surname;
	private String email;
	private String phone;
	public StudentResponse() {

	}
	public Long getIdentity() {
		return identity;
	}
	public void setIdentity(Long identity) {
		this.identity = identity;
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
	@Override
	public String toString() {
		return "StudentResponse [identity=" + identity + ", name=" + name + ", surname=" + surname + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	
	/*@Override
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
		StudentResponse other = (StudentResponse) obj;
		return Objects.equals(identity, other.identity);
	}
*/
}
