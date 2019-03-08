package com.viksuu.techie.transactionalmanagement.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "user")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "name", unique = false, nullable = false, columnDefinition = "VARCHAR(10)")
	private String name;
	
	@Column(name = "email", unique = false, nullable = false, columnDefinition = "VARCHAR(40)")
	private String email;

	@Column(name = "created_date", nullable = false, columnDefinition = "TIMESTAMP")
	private Date created_date;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "updated_date", nullable = false, columnDefinition = "TIMESTAMP")
	private Date updated_date;

	 

	public User(Integer id, String name, String email, Date created_date, Date updated_date) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.created_date = created_date;
		this.updated_date = updated_date;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, email=%s, created_date=%s, updated_date=%s]", id, name, email,
				created_date, updated_date);
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

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

}
