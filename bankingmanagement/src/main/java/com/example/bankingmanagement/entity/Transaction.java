package com.example.bankingmanagement.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transaction_id")
	private Long id;

	private String type;

	private double amount;

	private Date date;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;

	// Constructors, getters, and setters

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long id, String type, double amount, Date date, Account account) {
		super();
		this.id = id;
		this.type = type;
		this.amount = amount;
		this.date = date;
		this.account = account;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", type=" + type + ", amount=" + amount + ", date=" + date + ", account="
				+ account + "]";
	}

}
