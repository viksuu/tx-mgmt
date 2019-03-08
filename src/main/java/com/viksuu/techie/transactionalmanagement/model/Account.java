package com.viksuu.techie.transactionalmanagement.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;


@Entity
@Table(name = "account")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "account_holder_name", unique = false, nullable = false, columnDefinition = "VARCHAR(100)")
	private String account_holder_name;
	
	@Column(name = "balance", unique = false, nullable = false, columnDefinition = "VARCHAR(10)")
	private double balance;
	
	

	public Account() {
		super();
	}

	
	
	public Account(Integer id, String account_holder_name, double balance) {
		super();
		this.id = id;
		this.account_holder_name = account_holder_name;
		this.balance = balance;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccount_holder_name() {
		return account_holder_name;
	}

	public void setAccount_holder_name(String account_holder_name) {
		this.account_holder_name = account_holder_name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return String.format("Account [id=%s, account_holder_name=%s, balance=%s]", id, account_holder_name, balance);
	}
	
	
	
	

}
