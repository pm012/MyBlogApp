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
	private Boolean active;
	private String firstName;
	private String lastName;
	private String nickName;
	private String email;

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", active=" + active + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", nickName=" + nickName + ", email=" + email + "]";
	}

	public User() {

	}

	public User(String firstName, String email, String lastName, String nickName, Boolean active) {

		this.firstName = firstName;
		this.email = email;
		this.lastName = lastName;
		this.nickName = nickName;
		this.active = active;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getId() {
		return user_id;
	}

	public void setId(Integer id) {
		this.user_id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
