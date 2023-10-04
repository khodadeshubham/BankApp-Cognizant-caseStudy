package com.example.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.userservice.entity.EducationLoan;
import com.example.userservice.entity.LoanDetails;

@Repository
public interface EducationLoanRepository  extends JpaRepository<EducationLoan, Integer> {

	@Query
	public Optional<EducationLoan> findByLoanDetails(LoanDetails loanDetails);

}
