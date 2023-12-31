package com.example.bankservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.bankservice.dao.EducationLoanDao;
import com.example.bankservice.dao.PersonalLoanDao;
import com.example.bankservice.entity.EducationLoan;
import com.example.bankservice.entity.LoanDetails;
import com.example.bankservice.entity.PersonalLoan;
import com.example.bankservice.entity.User;
@RestController
@RequestMapping("/api/bank")
public class BankController {
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/user/{uid}")
	public User getUser(@PathVariable int uid) {
		return template.getForObject("http://user-service:8100/api/user/userDetails/"+uid, User.class);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Authorization", token);
//		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
//		HttpEntity<String> entity = new HttpEntity<>(headers);
//		return template.exchange("http://user-service:8100/api/user/userDetails/"+uid,HttpMethod.GET, entity, User.class);
	}
	
	
	@PostMapping("/addEducationLoan")
	public ResponseEntity<EducationLoan> saveEducationLoan(@RequestBody EducationLoanDao loan){
		
		EducationLoan eduLoan =  template.postForObject("http://user-service:8100/api/user/addEducationLoan",loan, EducationLoan.class);
		if(eduLoan != null)return new ResponseEntity<EducationLoan>(eduLoan,HttpStatus.CREATED );
		else return new ResponseEntity<EducationLoan>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/addPersonalLoan")
	public ResponseEntity<PersonalLoan> savePersonalLoan(@RequestBody PersonalLoanDao loan){
		PersonalLoan personalLoan = template.postForObject("http://user-service:8100/api/user/addPersonalLoan",loan, PersonalLoan.class);
		if(personalLoan != null)return new ResponseEntity<PersonalLoan>(personalLoan,HttpStatus.CREATED );
		else return new ResponseEntity<PersonalLoan>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/getAllLoans/{uid}")
	public ResponseEntity<List<LoanDetails>> getLoanDetailsByUser(@PathVariable int uid){
		List<LoanDetails> loans =  template.getForObject("http://user-service:8100/api/user/getLoansByUser/"+uid, List.class);
		return new ResponseEntity<List<LoanDetails>>(loans, HttpStatus.OK);
	}
	
	@GetMapping("/getLoanDetails/{loanId}")
	public ResponseEntity<Object> getLoanDetailsById(@PathVariable int loanId){
		Object o = template.getForObject("http://user-service:8100/api/user/getLoan/"+loanId, Object.class);
		
		if(o != null)return new ResponseEntity<Object>(o,HttpStatus.CREATED );
		else return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
	}

}
