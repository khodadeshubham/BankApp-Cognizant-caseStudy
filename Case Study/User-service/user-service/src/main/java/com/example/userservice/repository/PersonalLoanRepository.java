package com.example.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.entity.EducationLoan;
import com.example.userservice.entity.LoanDetails;
import com.example.userservice.entity.PersonalLoan;

@Repository
public interface PersonalLoanRepository extends JpaRepository<PersonalLoan, Integer> {

	public Optional<PersonalLoan> findByLoanDetails(LoanDetails loanDetails);
}
