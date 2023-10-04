package com.example.userservice.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="personal_loan")
public class PersonalLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personalLoanId;
	@Column
	private String company;
	@Column
	private String designation;
	@Column
	private int experience;
	@Column
	private int expWithCurrentCompany;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId", referencedColumnName = "loanId")
	private LoanDetails loanDetails;
	
	
	public PersonalLoan() {
		super();
	}


	public PersonalLoan(String company, String designation, int experience, int expWithCurrentCompany,
			LoanDetails loanDetails) {
		super();
		this.company = company;
		this.designation = designation;
		this.experience = experience;
		this.expWithCurrentCompany = expWithCurrentCompany;
		this.loanDetails = loanDetails;
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
