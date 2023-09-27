package com.example.userservice.dao;

public class BankAccountUpdateDAO {
	private int user_Id;
	private int bankId;
	private Double money;
	
	public BankAccountUpdateDAO(int user_Id, int bankId, Double money) {
		super();
		this.user_Id = user_Id;
		this.bankId = bankId;
		this.money = money;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getBankId() {
		return bankId;
	}

	public void setBankId(int bankId) {
		this.bankId = bankId;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}
	
	
}
