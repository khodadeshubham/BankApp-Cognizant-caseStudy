package com.example.userservice.entity;

import java.sql.Date;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="loan_details")
public class LoanDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;
	@Column
	private String loanType;
	@Column
	private Double loanAmmount;
	@Column
	private Double interest;
	@Column
	private Date loanDate;
	@Column
	private int duration;
	@Column
	private Double annualIncome;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_Id", referencedColumnName = "user_Id")
	@JsonIgnore
	private User user;
	
	public LoanDetails() {
		super();
	}

	public LoanDetails(String loanType, Double loanAmmount, Double interest, Date loanDate, int duration,
			Double annualIncome, User user) {
		super();
		this.loanType = loanType;
		this.loanAmmount = loanAmmount;
		this.interest = interest;
		this.loanDate = loanDate;
		this.duration = duration;
		this.annualIncome = annualIncome;
		this.user = user;
	}

	public LoanDetails(int loanId, String loanType, Double loanAmmount, Double interest, Date loanDate, int duration,
			Double annualIncome, User user) {
		super();
		this.loanId = loanId;
		this.loanType = loanType;
		this.loanAmmount = loanAmmount;
		this.interest = interest;
		this.loanDate = loanDate;
		this.duration = duration;
		this.annualIncome = annualIncome;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "LoanDetails [loanId=" + loanId + ", loanType=" + loanType + ", loanAmmount=" + loanAmmount
				+ ", interest=" + interest + ", loanDate=" + loanDate + ", duration=" + duration + ", annualIncome="
				+ annualIncome + "]";
	}
	
	
	
}
