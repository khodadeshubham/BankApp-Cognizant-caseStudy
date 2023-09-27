package com.example.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.dao.BankAccountDAO;
import com.example.userservice.dao.BankAccountUpdateDAO;
import com.example.userservice.dao.UserRegisterDao;
import com.example.userservice.entity.BankAccount;
import com.example.userservice.entity.User;
import com.example.userservice.service.BankService;
import com.example.userservice.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BankService bankService;
	
	@Autowired
//    private AuthenticationManager authenticationManager;


//    @PostMapping("/token")
//    public String getToken(@RequestBody AuthRequest authRequest) {
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            return service.generateToken(authRequest.getUsername());
//        } else {
//            throw new RuntimeException("invalid access");
//        }
//    }

//    @GetMapping("/validate")
//    public String validateToken(@RequestParam("token") String token) {
//        service.validateToken(token);
//        return "Token is valid";
//    }
	
	@PostMapping("/addUser")
	public ResponseEntity<BankAccount> addUser(@RequestBody UserRegisterDao u){
		User newUser = new User(u.getName(), u.getUserName(),u.getPassword(), u.getAddress(), u.getCountry(), u.getState(), u.getEmail(), u.getContact(), u.getDob());
		BankAccount newBankAccount = new BankAccount(u.getAccountNumber(),u.getAccountType(),u.getBranch(),u.getBalance(),u.getDocument(),u.getDocumentNumber(),newUser);
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
	
	@GetMapping("/userBankDetails/{uid}")
	public ResponseEntity<BankAccountDAO> getUserBankDetails(@PathVariable int uid){
		BankAccountDAO u= bankService.findUserBankDetails(uid);
		ResponseEntity<BankAccountDAO > resp = new ResponseEntity<BankAccountDAO>(u, HttpStatus.OK);
		return resp;
	}
	
	@PutMapping("/depositeMoney")
	public ResponseEntity<BankAccount> depositeMoney(@RequestBody BankAccountUpdateDAO b){
		BankAccount bc = bankService.depositeMoney(b);
		return new ResponseEntity<BankAccount>(bc, HttpStatus.OK);
	}
}
