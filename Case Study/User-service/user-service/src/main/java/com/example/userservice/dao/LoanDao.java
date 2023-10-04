package com.example.userservice.dao;

import java.sql.Date;

public class LoanDao {

	private int loanId;
	private String loanType;
	private Double loanAmmount;
	private Double interest;
	private Date loanDate;
	private int duration;
	private Double annualIncome;
	private int userId;
	
	
	public LoanDao() {
		super();
	}

	
	public LoanDao(String loanType, Double loanAmmount, Double interest, Date loanDate, int duration,
			Double annualIncome, int userId) {
		super();
		this.loanType = loanType;
		this.loanAmmount = loanAmmount;
		this.interest = interest;
		this.loanDate = loanDate;
		this.duration = duration;
		this.annualIncome = annualIncome;
		this.userId = userId;
	}


	public LoanDao(int loanId, String loanType, Double loanAmmount, Double interest, Date loanDate, int duration,
			Double annualIncome, int userId) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmmount = loanAmmount;
		this.interest = interest;
		this.loanDate = loanDate;
		this.duration = duration;
		this.annualIncome = annualIncome;
		this.userId = userId;
	}


	public int getLoanId() {
		return loanId;
	}


	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}


	public String getLoanType() {
		return loanType;
	}


	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}


	public Double getLoanAmmount() {
		return loanAmmount;
	}


	public void setLoanAmmount(Double loanAmmount) {
		this.loanAmmount = loanAmmount;
	}


	public Double getInterest() {
		return interest;
	}


	public void setInterest(Double interest) {
		this.interest = interest;
	}


	public Date getLoanDate() {
		return loanDate;
	}


	public void setLoanDate(Date loanDate) {
		this.loanDate = loanDate;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public Double getAnnualIncome() {
		return annualIncome;
	}


	public void setAnnualIncome(Double annualIncome) {
		this.annualIncome = annualIncome;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	
}
