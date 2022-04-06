package com.ankit.springmvcboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ankit.springmvcboot.model.User;
import com.ankit.springmvcboot.repository.UserRepository;

import java.util.List;
@RestController
@RequestMapping("")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	//get all user
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userRepository.findAll();
	}
	
	@PostMapping("/user/signup")
	@CrossOrigin(origins="http://localhost:4200")
	public User createUser(@RequestBody User usr) {
		return userRepository.save(usr);
	}
}
