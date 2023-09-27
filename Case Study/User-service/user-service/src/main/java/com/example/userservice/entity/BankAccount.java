package com.example.userservice.entity;


import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
@Entity
@Table(name= "bank_account")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bankId;
	@Column(name="accountNumber")
	private String accountNumber;
	@Column(name="accountType")
	private String accountType;
	@Column(name="branch")
	private String branch;
	@Column(name="balance")
	private Double balance;
	@Column(name="documnet")
	private String document;
	@Column(name="documentNumber")
	private String documentNumber;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	@JsonIgnore
	private User user;
	
	
	public BankAccount() {
		super();
	}


	
	public BankAccount(String accountNumber, String accountType, String branch, Double balance, String document,
			String documentNumber, User user) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branch = branch;
		this.balance = balance;
		this.document = document;
		this.documentNumber = documentNumber;
		this.user = user;
	}



	public BankAccount(int bankId, String accountNumber, String accountType, String branch, Double balance,
			String document, String documentNumber, User user) {
		super();
		this.bankId = bankId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.branch = branch;
		this.balance = balance;
		this.document = document;
		this.documentNumber = documentNumber;
		this.user = user;
	}



	public int getBankId() {
		return bankId;
	}


	public void setBankId(int bankId) {
		this.bankId = bankId;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}


	public String getBranch() {
		return branch;
	}


	public void setBranch(String branch) {
		this.branch = branch;
	}


	public Double getBalance() {
		return balance;
	}


	public void setBalance(Double balance) {
		this.balance = balance;
	}


	public String getDocument() {
		return document;
	}


	public void setDocument(String document) {
		this.document = document;
	}


	public String getDocumentNumber() {
		return documentNumber;
	}


	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public String getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
	
}
