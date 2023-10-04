package com.example.userservice.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.dao.EducationLoanDao;
import com.example.userservice.dao.LoanDao;
import com.example.userservice.dao.PersonalLoanDao;
import com.example.userservice.entity.EducationLoan;
import com.example.userservice.entity.LoanDetails;
import com.example.userservice.entity.PersonalLoan;
import com.example.userservice.entity.User;
import com.example.userservice.repository.EducationLoanRepository;
import com.example.userservice.repository.LoanRepository;
import com.example.userservice.repository.PersonalLoanRepository;
import com.example.userservice.repository.UserRepository;
import com.netflix.discovery.converters.Auto;

@Service
public class LoanService {
	
	@Autowired
	PersonalLoanRepository personalLoanRepo;
	
	@Autowired
	EducationLoanRepository educationLoanRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	LoanRepository loanRepo;
	
	public List<LoanDetails> getLoanDetailsByUser(int uid){
		return (List<LoanDetails>) loanRepo.getLoanDetailsByUserId(uid);
	}
	
	public EducationLoan saveEducationLoan(EducationLoanDao loan) {
		User u = userRepo.findById(loan.getUserId()).get();
		LoanDetails newLoan = new LoanDetails(loan.getLoanType(), loan.getLoanAmmount(), loan.getInterest(),loan.getLoanDate(), loan.getDuration(), loan.getAnnualIncome(), u);
		EducationLoan newEduLoan = new EducationLoan(loan.getCourseFee(),loan.getCourse(), loan.getFather(),loan.getFatherOccupation(),newLoan);
		return educationLoanRepo.save(newEduLoan);
	}

	public PersonalLoan savePersonalLoan(PersonalLoanDao loan) {
		User u = userRepo.findById(loan.getUserId()).get();
		LoanDetails newLoan = new LoanDetails(loan.getLoanType(), loan.getLoanAmmount(), loan.getInterest(),loan.getLoanDate(), loan.getDuration(), loan.getAnnualIncome(), u);
		PersonalLoan newPersonalLoan = new PersonalLoan(loan.getCompany(),loan.getDesignation(), loan.getExperience(),loan.getExpWithCurrentCompany(),newLoan);
		return personalLoanRepo.save(newPersonalLoan);
	}
	
	public Optional<Object> getLoanById(int loanId) {
		LoanDetails loan = loanRepo.findById(loanId).get();
		System.out.println(loan.toString());
		System.out.println(loan.getLoanType());
		if(loan.getLoanType().equals("Education")) return Optional.of(educationLoanRepo.findByLoanDetails(loan));
		else return Optional.of(personalLoanRepo.findByLoanDetails(loan));
	}
}
