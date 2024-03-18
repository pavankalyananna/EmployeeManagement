package com.employee.ems.dto;

public class EmployeeDto {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public EmployeeDto(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
	

}
