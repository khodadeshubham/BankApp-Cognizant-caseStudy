package com.example.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.userservice.entity.BankAccount;
import com.example.userservice.entity.User;

@Repository
public interface BankRepository extends JpaRepository<BankAccount, Integer> {

	@Query(value = "SELECT b FROM BankAccount b WHERE user = :u")
	public List<BankAccount> getUserBankDetails(User u);
}
