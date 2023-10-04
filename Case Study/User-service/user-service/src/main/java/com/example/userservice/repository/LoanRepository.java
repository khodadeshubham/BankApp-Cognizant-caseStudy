package com.example.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.userservice.entity.EducationLoan;
import com.example.userservice.entity.LoanDetails;

@Repository
public interface LoanRepository extends JpaRepository<LoanDetails, Integer>  {

	@Query(value= "SELECT * FROM loan_details l WHERE user_Id = :uid", nativeQuery = true)
	public List<LoanDetails> getLoanDetailsByUserId(int uid);
	
}
