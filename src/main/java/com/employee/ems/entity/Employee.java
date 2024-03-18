package com.employee.ems.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	public Employee() {
		
	}
	private String firstName;
	private String lastName;
	private String email;
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee(Long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public void setFirstName(String firstName2) {
		// TODO Auto-generated method stub
		this.firstName=firstName2;
	}
	

}
