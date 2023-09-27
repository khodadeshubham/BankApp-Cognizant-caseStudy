package com.example.userservice.dao;

import java.sql.Date;

public class UserRegisterDao {
	private String name;
	private String userName;
	private String password;
	private String address;
	private String country;
	private String state;
	private String email;
	private String contact;
	private Date dob;
	private String accountType;
	private String accountNumber;
	private String branch;
	private Double balance;
	private String document;
	private String documentNumber;
	
	
	public UserRegisterDao() {
		super();
	}
	
	
	public UserRegisterDao(String name, String userName, String password, String address, String country, String state,
			String email, String contact, Date dob, String accountType, String accountNumber, String branch,
			Double balance, String document, String documentNumber) {
		super();
		this.name = name;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.country = country;
		this.state = state;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
		this.accountType = accountType;
		this.accountNumber = accountNumber;
		this.branch = branch;
		this.balance = balance;
		this.document = document;
		this.documentNumber = documentNumber;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
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
	
	
}
