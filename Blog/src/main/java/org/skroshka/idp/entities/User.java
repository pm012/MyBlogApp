package org.skroshka.idp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	// for oracle the values in the brackets may not be specified for
	// autogeneration. These db use own sequence table to generate values
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer user_id;
	private String name;
	private String lastName;
	// private String userName;
	private String email;

	@Override
	public String toString() {
		return "User [id=" + user_id + ", name=" + name + ", email=" + email + ", lastName=" + lastName + "]";
	}

	public User() {

	}

	public User(String name, String email, String lastName, String userName) {

		this.name = name;
		this.email = email;
		this.lastName = lastName;
		// this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/*
	 * public String getUserName() { return userName; }
	 */

	/*
	 * public void setUserName(String userName) { this.userName = userName; }
	 */

	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
