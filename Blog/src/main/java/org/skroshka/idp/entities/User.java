package org.skroshka.idp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "USER")
public class User {

	private Long user_id;
	private Boolean active;
	private String firstName;
	private String lastName;
	@Length(min = 5, message = "*Your username must have at least 5 characters")
	@NotEmpty(message = "*Please provide your name")
	private String nickName;
	@Email(message = "*Please provide a valid Email")
	@NotEmpty(message = "*Please provide an email")
	private String email;

	// private Collection<Role> roles;

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

	@Column(name = "email", unique = true, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "active", nullable = false)
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "nick_name", nullable = false, unique = true)
	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Id
	// for oracle the values in the brackets may not be specified for
	// autogeneration. These db use own sequence table to generate values
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	public Long getId() {
		return user_id;
	}

	public void setId(Long id) {
		this.user_id = id;
	}

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/*
	 * @ManyToMany(cascade = CascadeType.ALL)
	 * 
	 * @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
	 * inverseJoinColumns = @JoinColumn(name = "role_id")) public Collection<Role>
	 * getRoles() { return roles; }
	 * 
	 * public void setRoles(Collection<Role> roles) { this.roles = roles; }
	 */

}
