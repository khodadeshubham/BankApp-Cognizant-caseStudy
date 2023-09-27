package com.example.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.entity.User;
import com.example.userservice.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User addUser(User u) {
		return userRepo.save(u);
	}
	
	public User findUser(int uid) {
		return userRepo.findById(uid).get();
	}
}
