package org.skroshka.idp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

@Table(name = "ROLE")
public class Role {

	private Long id;
	private String role;
	// private Collection<User> users;

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column(name = "role_id")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "role", unique = true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*
	 * @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles") public
	 * Collection<User> getUsers() { return users; }
	 * 
	 * public void setUsers(Collection<User> users) { this.users = users; }
	 */

}
