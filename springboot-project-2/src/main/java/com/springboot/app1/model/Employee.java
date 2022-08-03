package com.springboot.app1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;


// Lombok "@Data" library reduces boilerplate code such as getters, setters, constructors, toString, equals, and hashacode methods
// @Entity specifies that a class is an entity
// @Table pecifies a table for the entity

@Data
@Entity
@Table(name="employees")
public class Employee {

	// Identifies the primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long id;
	
	//@NotNull
	@Column(name = "first_name" )
	public String firstName;
	
	@Column(name = "last_name")
	public String lastName;
	
	@Column(name = "email")
	public String email;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
}
