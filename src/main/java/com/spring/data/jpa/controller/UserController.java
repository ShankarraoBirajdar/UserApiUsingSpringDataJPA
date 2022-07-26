package com.spring.data.jpa.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.data.jpa.entities.User;
import com.spring.data.jpa.services.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService userSevice;
	
	@GetMapping("/get/users")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = userSevice.getAllUser();
		if(list.size()>0)
		return ResponseEntity.ok(list);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@GetMapping("/get/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id) {
		User user = userSevice.getUserById(id);
		if(user==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok(user);
		
	}
	
	@PostMapping("/add/user")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		boolean isUserCreated = userSevice.addUser(user);
		if(isUserCreated) {
			return new ResponseEntity<Object>("User Created Successfully",HttpStatus.CREATED);
		}
		return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/delete/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable("id") int id) {
		 boolean isUserDeleted =userSevice.deleteUserById(id);
		if(isUserDeleted) {
			return new ResponseEntity<Object>("User Deleted Successfully",HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/update/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") int id, @RequestBody User user) {
	User user2 = userSevice.getUserById(id);
	if (user2 == null) {
		userSevice.addUser(user);
		return new ResponseEntity<Object>("User Created Successfully",HttpStatus.CREATED);
	}
	userSevice.updateUserUsingPut(id, user);
	return new ResponseEntity<Object>("User Updated Successfully",HttpStatus.OK);
	}
	
	@PatchMapping("/update/user/{id}")
	public ResponseEntity<?> updateUserPatch(@PathVariable("id") int id, @RequestBody User user) {
		boolean isUserUpdated = userSevice.updateUserUsingPatch(id, user);
		if (isUserUpdated) {
			return new ResponseEntity<Object>("User Updated Successfully",HttpStatus.OK);
		}
		return new ResponseEntity<Object>("User Not Found",HttpStatus.NOT_FOUND);
	}
	

}
