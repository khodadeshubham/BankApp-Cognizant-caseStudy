package com.example.bankservice.entity;

public class EducationLoan {
	private int educationLoanId;
	private Double courseFee;
	private String course;
	private String father;
	private String fatherOccupation;
	private LoanDetails loanDetails;
	
	
	public EducationLoan() {
		super();
	}


	public EducationLoan(int educationLoanId, Double courseFee, String course, String father, String fatherOccupation,
			LoanDetails loanDetails) {
		super();
		this.educationLoanId = educationLoanId;
		this.courseFee = courseFee;
		this.course = course;
		this.father = father;
		this.fatherOccupation = fatherOccupation;
		this.loanDetails = loanDetails;
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


	public LoanDetails getLoanDetails() {
		return loanDetails;
	}


	public void setLoanDetails(LoanDetails loanDetails) {
		this.loanDetails = loanDetails;
	}
	
	
}
