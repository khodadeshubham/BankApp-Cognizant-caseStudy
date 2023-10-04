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
@Table(name="education_loan")
public class EducationLoan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int educationLoanId;
	@Column
	private Double courseFee;
	@Column
	private String course;
	@Column
	private String father;
	@Column
	private String fatherOccupation;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "loanId", referencedColumnName = "loanId")
	private LoanDetails loanDetails;
	
	public EducationLoan() {
		super();
	}

	public EducationLoan(Double courseFee, String course, String father, String fatherOccupation,
			LoanDetails loanDetails) {
		super();
		this.courseFee = courseFee;
		this.course = course;
		this.father = father;
		this.fatherOccupation = fatherOccupation;
		this.loanDetails = loanDetails;
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

	@Override
	public String toString() {
		return "EducationLoan [educationLoanId=" + educationLoanId + ", courseFee=" + courseFee + ", course=" + course
				+ ", father=" + father + ", fatherOccupation=" + fatherOccupation + ", loanDetails=" + loanDetails
				+ "]";
	}
	
	
	
}
