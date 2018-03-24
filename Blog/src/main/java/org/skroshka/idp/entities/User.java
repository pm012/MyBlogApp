package org.skroshka.idp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String lastName;
	private String userName;
	private String email;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", lastName=" + lastName + ", userName="
				+ userName + "]";
	}

	public User() {
		super();
	}

	public User(String name, String email, String lastName, String userName) {

		this.name = name;
		this.email = email;
		this.lastName = lastName;
		this.userName = userName;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
