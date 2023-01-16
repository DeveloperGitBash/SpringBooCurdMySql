package com.myreddy.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myreddy.springboot.bean.User;
import com.myreddy.springboot.repository.MyRepository;

@RestController
@RequestMapping("app/user")
public class MyController {
	
	@Autowired
	MyRepository repository;
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user){
		System.out.println("repository"+repository);
		User saveUser =repository.save(user);
		return new ResponseEntity<User>(saveUser,HttpStatus.OK);
	}
	@GetMapping("/userdetails")
	public ResponseEntity<List<User>> getUsers(){
		
		List<User> saveUser =repository.findAll();
		return new ResponseEntity<>(saveUser,HttpStatus.OK);
	}
	@GetMapping("/userByID/{userid}")
	public ResponseEntity<User> getUserByID(@PathVariable Long userid){
		
		User saveUser =repository.findById(userid).get();
		return new ResponseEntity<>(saveUser,HttpStatus.OK);
	}
	@PutMapping("/update/{userid}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable Long userid){
		
		User saveUser =repository.findById(userid).get();
		saveUser.setUserName(user.getUserName());
		saveUser.setPassword(user.getPassword());
		saveUser.setEmil(user.getEmil());
		User update =repository.save(saveUser);
		return new ResponseEntity<>(update,HttpStatus.OK);
	}
	
}
