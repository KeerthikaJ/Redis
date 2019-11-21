package com.example.cache.springredisexample.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cache.springredisexample.model.User;
import com.example.cache.springredisexample.repository.UserRepository;

@RestController
@RequestMapping("/rest/user")
public class UserController {

	private UserRepository userRepository;
	
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@GetMapping("/add/{id}/{name}")
	public User add(@PathVariable("id") String id, @PathVariable("name") String name) {
		userRepository.save(new User(id, name, 50000L));
		
		return userRepository.findById(id);
	}
	
	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") String id, @PathVariable("name") String name) {
		userRepository.save(new User(id, name, 80000L));
		
		return userRepository.findById(id);
	}
	
	@GetMapping("/all")
	public Map<String, User> findAll(@PathVariable("id") String id, @PathVariable("name") String name) {
		
		return userRepository.findAll();
	}
}
