package com.spring.data.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.jpa.entities.Registration;
import com.spring.data.jpa.services.RegistartionService;

@RestController
public class RegistrationController {
	@Autowired
	private RegistartionService registartionService;
	
	@GetMapping("/get/registartion/users")
	public ResponseEntity<List<Registration>> getAllUsers() {
		List<Registration> list = registartionService.getAllUser();
		if(list.size()>0)
		return ResponseEntity.ok(list);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/get/registartion/user/{id}")
	public ResponseEntity<Registration> getUserById(@PathVariable("id") int id) {
		Registration user = registartionService.getUserById(id);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping("/create/registartion/user")
	public ResponseEntity<?> addUser(@RequestBody Registration user) {
		System.out.println("post: "+user.toString());
		boolean isUserCreated = registartionService.addUser(user);
		if(isUserCreated) {
			return new ResponseEntity<Object>("User Created Successfully",HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/delete/registartion/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		 boolean isUserDeleted =registartionService.deleteUserById(id);
		if(isUserDeleted) {
			return new ResponseEntity<Object>("User Deleted Successfully",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/update/registartion/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody Registration user) {
		Registration user2 = registartionService.getUserById(id);
	if (user2 == null) {
		registartionService.addUser(user);
		return new ResponseEntity<Object>("User Created Successfully",HttpStatus.CREATED);
	}
	registartionService.updateUserUsingPut(id, user);
	return new ResponseEntity<Object>("User Updated Successfully",HttpStatus.OK);
	}

}
