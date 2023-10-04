package com.example.bankservice.dao;


import java.sql.Date;

public class PersonalLoanDao extends LoanDao {

	private int personalLoanId;
	private String company;
	private String designation;
	private int experience;
	private int expWithCurrentCompany;

	

	public PersonalLoanDao() {
		super();
	}



	public PersonalLoanDao(int loanId, String loanType, Double loanAmmount, Double interest, Date loanDate,
			int duration, Double annualIncome, int userId, int personalLoanId, String company, String designation, int experience,
			int expWithCurrentCompany) {
		super(loanId, loanType, loanAmmount, interest, loanDate, duration, annualIncome, userId);
		// TODO Auto-generated constructor stub
		this.personalLoanId = personalLoanId;
		this.company = company;
		this.designation = designation;
		this.experience = experience;
		this.expWithCurrentCompany = expWithCurrentCompany;
	}



	public PersonalLoanDao(String loanType, Double loanAmmount, Double interest, Date loanDate, int duration,
			Double annualIncome, int userId,String company, String designation, int experience,
			int expWithCurrentCompany) {
		super(loanType, loanAmmount, interest, loanDate, duration, annualIncome, userId);
		// TODO Auto-generated constructor stub
		this.company = company;
		this.designation = designation;
		this.experience = experience;
		this.expWithCurrentCompany = expWithCurrentCompany;
	}



	public PersonalLoanDao(int personalLoanId, String company, String designation, int experience,
			int expWithCurrentCompany) {
		super();
		this.personalLoanId = personalLoanId;
		this.company = company;
		this.designation = designation;
		this.experience = experience;
		this.expWithCurrentCompany = expWithCurrentCompany;
	}



	public int getPersonalLoanId() {
		return personalLoanId;
	}



	public void setPersonalLoanId(int personalLoanId) {
		this.personalLoanId = personalLoanId;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public String getDesignation() {
		return designation;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public int getExperience() {
		return experience;
	}



	public void setExperience(int experience) {
		this.experience = experience;
	}



	public int getExpWithCurrentCompany() {
		return expWithCurrentCompany;
	}



	public void setExpWithCurrentCompany(int expWithCurrentCompany) {
		this.expWithCurrentCompany = expWithCurrentCompany;
	}

	
	
}

