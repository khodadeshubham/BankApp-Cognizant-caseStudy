package com.example.userservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dao.AuthRequest;
import com.example.userservice.dao.BankAccountDAO;
import com.example.userservice.dao.BankAccountUpdateDAO;
import com.example.userservice.dao.EducationLoanDao;
import com.example.userservice.dao.PersonalLoanDao;
import com.example.userservice.dao.UserRegisterDao;
import com.example.userservice.entity.BankAccount;
import com.example.userservice.entity.EducationLoan;
import com.example.userservice.entity.LoanDetails;
import com.example.userservice.entity.PersonalLoan;
import com.example.userservice.entity.User;
import com.example.userservice.service.BankService;
import com.example.userservice.service.LoanService;
import com.example.userservice.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
	LoanService loanService;
	
	@Autowired
    private AuthenticationManager authenticationManager;


	 @PostMapping("/login")
	    public ResponseEntity<Map<String,Object>> getToken(@RequestBody AuthRequest authRequest) {
	        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
	        if (authenticate.isAuthenticated()) {
	        	Map<String,Object> result = new HashMap<String, Object>();
	        	result.put("token", bankService.generateToken(authRequest.getUserName()));
	        	User u = userService.findUserByUserName(authRequest.getUserName());
	        	result.put("user", u);
	            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	        } else {
	        	Map<String,Object> result = new HashMap<String, Object>();
	        	result.put("message", "invalid user");
	        	return new ResponseEntity<Map<String, Object>>(result, HttpStatus.NOT_FOUND);
//	            throw new RuntimeException("invalid access");
	            
	        }
	    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        bankService.validateToken(token);
        return "Token is valid";
    }
	
	@PostMapping("/register")
	public ResponseEntity<BankAccount> addUser(@RequestBody UserRegisterDao u){
		User newUser = new User(u.getName(), u.getUserName(),u.getPassword(), u.getAddress(), u.getCountry(),u.getState(), u.getEmail(), u.getContact(), u.getDob());
		BankAccount newBankAccount = new BankAccount(u.getAccountType(),u.getBranch(),u.getBalance(),u.getDocument(),u.getDocumentNumber(),newUser);
		BankAccount ba = bankService.addUser(newBankAccount);
		if(ba != null)
		return new ResponseEntity<BankAccount>(ba, HttpStatus.CREATED);
		else return new ResponseEntity<BankAccount>(ba, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/userDetails/{uid}")
	public ResponseEntity<User> getUserDetails(@PathVariable int uid){
		User u= userService.findUser(uid);
		ResponseEntity<User> resp = new ResponseEntity<User>(u, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/checkUserPresence/{userName}")
	public ResponseEntity<User> getUserDetails(@PathVariable String userName){
		User u= userService.findUserByUserName(userName);
		if(u != null) {
		ResponseEntity<User> resp = new ResponseEntity<User>(u, HttpStatus.OK);
		return resp;
		}else return null;
	}
	
	@GetMapping("/userBankDetails/{uid}")
	public ResponseEntity<BankAccountDAO> getUserBankDetails(@PathVariable int uid){
		System.out.println("called");
		BankAccountDAO u= bankService.findUserBankDetails(uid);
		ResponseEntity<BankAccountDAO > resp = new ResponseEntity<BankAccountDAO>(u, HttpStatus.OK);
		return resp;
	}
	
	@PutMapping("/depositMoney")
	public ResponseEntity<BankAccount> depositeMoney(@RequestBody BankAccountUpdateDAO b){
		BankAccount bc = bankService.depositeMoney(b);
		return new ResponseEntity<BankAccount>(bc, HttpStatus.OK);
	}
	
	@GetMapping("/getLoansByUser/{uid}")
	public List<LoanDetails> getLoanDetailsByUser(@PathVariable int uid){
		List<LoanDetails> loans = loanService.getLoanDetailsByUser(uid);
		return loans;
	}
	
	@PostMapping("/addEducationLoan")
	public EducationLoan saveEducationLoan(@RequestBody EducationLoanDao loan){
		System.out.println(loan.toString());
		System.out.println(loan.getUserId());
		EducationLoan eduLoan = loanService.saveEducationLoan(loan);
		return eduLoan;
	}
	
	@PostMapping("/addPersonalLoan")
	public PersonalLoan savePersonalLoan(@RequestBody PersonalLoanDao loan){
		PersonalLoan personalLoan = loanService.savePersonalLoan(loan);
		return personalLoan;
	}
	
	@GetMapping("/getLoan/{loanId}")
	public Object getLoadDetailsById(@PathVariable int loanId) {
		return loanService.getLoanById(loanId);
	}
}
