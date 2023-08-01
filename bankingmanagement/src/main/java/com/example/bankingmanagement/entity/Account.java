package com.example.bankingmanagement.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long id;

	private String accountNumber;

	private double balance;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	private List<Transaction> transactions;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(Long id, String accountNumber, double balance, Customer customer, List<Transaction> transactions) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.customer = customer;
		this.transactions = transactions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

//	public List<Transaction> getTransactions() {
//		return transactions;
//	}
//
//	public void setTransactions(List<Transaction> transactions) {
//		this.transactions = transactions;
//	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountNumber=" + accountNumber + ", balance=" + balance + ", customer="
				+ customer + ", transactions=" + transactions + "]";
	}

}
