package com.example.bankservice.entity;

public class PersonalLoan {

	private int personalLoanId;
	private String company;
	private String designation;
	private int experience;
	private int expWithCurrentCompany;
	private LoanDetails loanDetails;
	
	
	public PersonalLoan() {
		super();
	}


	public PersonalLoan(int personalLoanId, String company, String designation, int experience,
			int expWithCurrentCompany, LoanDetails loanDetails) {
		super();
		this.personalLoanId = personalLoanId;
		this.company = company;
		this.designation = designation;
		this.experience = experience;
		this.expWithCurrentCompany = expWithCurrentCompany;
		this.loanDetails = loanDetails;
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


	public LoanDetails getLoanDetails() {
		return loanDetails;
	}


	public void setLoanDetails(LoanDetails loanDetails) {
		this.loanDetails = loanDetails;
	}
	
	
	
}
