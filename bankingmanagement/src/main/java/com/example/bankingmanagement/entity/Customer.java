package com.example.bankingmanagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private int id;

	private String name;

	private String email;

	private String password;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> accounts;

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, String email, String password, List<Account> accounts) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.accounts = accounts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", accounts="
				+ accounts + "]";
	}

}
