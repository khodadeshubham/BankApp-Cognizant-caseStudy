package com.example.userservice.dao;

import java.sql.Date;
import java.util.List;

import com.example.userservice.entity.BankAccount;

public class BankAccountDAO {
	private int user_Id;
	private String name;
	private String userName;
	private String address;
	private String country;
	private String state;
	private String email;
	private String contact;
	private Date dob;
	private List<BankAccount> bankDetails;
	
	public BankAccountDAO(int user_Id, String name, String userName, String address, String country, String state,
			String email, String contact, Date dob, List<BankAccount> bankList) {
		super();
		this.user_Id = user_Id;
		this.name = name;
		this.userName = userName;
		this.address = address;
		this.country = country;
		this.state = state;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
		this.bankDetails = bankList;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
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

	public List<BankAccount> getBankList() {
		return bankDetails;
	}

	public void setBankList(List<BankAccount> bankList) {
		this.bankDetails = bankList;
	}
	
	
	
}
