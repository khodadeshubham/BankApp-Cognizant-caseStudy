package com.example.userservice.service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		 BankAccount b=bankRepo.save(u);
		 b.setAccountNumber(generateTwelveDigitId(b.getAccountId()));
		
		 return bankRepo.save(b);
	}
	
	public BankAccountDAO findUserBankDetails(int uid) {
		User u = userRepo.findById(uid).orElse(null);
		List<BankAccount> bankDetails= bankRepo.getUserBankDetails(u);
		return new BankAccountDAO(uid, u.getName(), u.getUserName(), u.getAddress(), u.getCountry(), u.getState(), u.getEmail(), u.getContact(), u.getDob(), bankDetails);
	}
	
	public BankAccount depositeMoney(BankAccountUpdateDAO b) {
		User u = userRepo.findById(b.getUser_Id()).orElse(null);
		BankAccount account = bankRepo.findBankAccountByUser(u);
		System.out.println(account);
		if(account != null) {
			Double newBalance = account.getBalance() + b.getMoney();
			account.setBalance(newBalance);
			return bankRepo.save(account);
		}
		else return null;
	
	}
	
	private String generateTwelveDigitId(int integerId) {
	    if (integerId > 0) {
	        // Convert the integer ID to a 12-digit format by padding with zeros
	        String twelveDigitId = String.format("%012d", integerId);
	        
	        // Optionally, you can add a prefix to the ID
	        // For example, if you want "ABC" as a prefix:
	        // String twelveDigitIdWithPrefix = "ABC" + twelveDigitId;
	        
	        return twelveDigitId;
	    }
	    return null; // Handle cases where the integer ID is invalid.
	}
}
