package com.example.bankservice.dao;

import java.sql.Date;


public class EducationLoanDao extends LoanDao {

	private int educationLoanId;
	private Double courseFee;
	private String course;
	private String father;
	private String fatherOccupation;
	
	public EducationLoanDao() {
		super();
	}

	public EducationLoanDao(int loanId, String loanType, Double loanAmmount, Double interest, Date loanDate,
			int duration, Double annualIncome, int userId, int educationLoanId, Double courseFee, String course, String father,
			String fatherOccupation) {
		super(loanId, loanType, loanAmmount, interest, loanDate, duration, annualIncome, userId);
		this.educationLoanId = educationLoanId;
		this.courseFee = courseFee;
		this.course = course;
		this.father = father;
		this.fatherOccupation = fatherOccupation;
	}

	public EducationLoanDao(String loanType, Double loanAmmount, Double interest, Date loanDate, int duration,
			Double annualIncome, int userId, Double courseFee, String course, String father,
			String fatherOccupation) {
		super(loanType, loanAmmount, interest, loanDate, duration, annualIncome, userId);
		this.courseFee = courseFee;
		this.course = course;
		this.father = father;
		this.fatherOccupation = fatherOccupation;
	}

	public EducationLoanDao(int educationLoanId, Double courseFee, String course, String father,
			String fatherOccupation) {
		super();
		this.educationLoanId = educationLoanId;
		this.courseFee = courseFee;
		this.course = course;
		this.father = father;
		this.fatherOccupation = fatherOccupation;
	}

	public int getEducationLoanId() {
		return educationLoanId;
	}

	public void setEducationLoanId(int educationLoanId) {
		this.educationLoanId = educationLoanId;
	}

	public Double getCourseFee() {
		return courseFee;
	}

	public void setCourseFee(Double courseFee) {
		this.courseFee = courseFee;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getFather() {
		return father;
	}

	public void setFather(String father) {
		this.father = father;
	}

	public String getFatherOccupation() {
		return fatherOccupation;
	}

	public void setFatherOccupation(String fatherOccupation) {
		this.fatherOccupation = fatherOccupation;
	}
	
	
	
}

