package com.example.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.userservice.dao.BankAccountDAO;
import com.example.userservice.dao.BankAccountUpdateDAO;
import com.example.userservice.entity.BankAccount;
import com.example.userservice.entity.User;
import com.example.userservice.repository.BankRepository;
import com.example.userservice.repository.UserRepository;

@Service
public class BankService {

	@Autowired
	BankRepository bankRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	PasswordEncoder passEndoder;
	
	@Autowired
	JwtService jwtService;
	
	public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }
    
	public BankAccount addUser(BankAccount u) {
		User newUser = u.getUser();
		newUser.setPassword(passEndoder.encode(newUser.getPassword()));
		u.setUser(newUser);
		return bankRepo.save(u);
	}
	
	public BankAccountDAO findUserBankDetails(int uid) {
		User u = userRepo.findById(uid).get();
		List<BankAccount> bankDetails= bankRepo.getUserBankDetails(u);
		return new BankAccountDAO(uid, u.getName(), u.getUserName(), u.getAddress(), u.getCountry(), u.getState(), u.getEmail(), u.getContact(), u.getDob(), bankDetails);
	}
	
	public BankAccount depositeMoney(BankAccountUpdateDAO b) {
		BankAccount account = bankRepo.findById(b.getBankId()).get();
		Double newBalance = account.getBalance() + b.getMoney();
		account.setBalance(newBalance);
		return bankRepo.save(account);
	}
}
