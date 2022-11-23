package com.spring.data.jpa.services;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.jpa.entities.User;
import com.spring.data.jpa.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUser() {
		List<User> users = (List<User>) userRepository.findAll();
		return users;
	}

	public User getUserById(int id) {
		if (userRepository.existsById(id)) {
			Optional<User> optional = userRepository.findById(id);
			User user = optional.get();
			System.out.println(user);
			return user;
		} else {
			System.out.println("User Not Exist");
			return null;
		}

	}

	@Transactional
	public boolean addUser( User user) {
		boolean isUserCreated=false;
		if(user!=null) {
			// save single Object
			User result = userRepository.save(user);
			isUserCreated=true;
			System.out.println(result);
			return isUserCreated;
		}
		else {
			return isUserCreated;
		}

	}

	
	@Transactional
	public boolean updateUserUsingPut(int id,User user) {
		boolean isUserUpdated=false;
		if (userRepository.existsById(id)) {
			Optional<User> optional = userRepository.findById(id);
			User user2 = optional.get();
			user2.setName(user.getName());
			user2.setGender(user.getGender());
			user2.setSalary(user.getSalary());
			User resultUser = userRepository.save(user2);
			isUserUpdated=true;
			System.out.println(resultUser);
			
		}
		return isUserUpdated;
	}
	
	@Transactional
	public boolean updateUserUsingPatch(int id, User user) {
		boolean isUserUpdated = false;
			if (userRepository.existsById(id)) {
				Optional<User> optional = userRepository.findById(id);
				User user2 = optional.get();
				 System.out.println(user.getName());
				 System.out.println(user.getGender());
				 System.out.println(user.getSalary());
				 if(user.getName()!=null) {
					 user2.setName(user.getName());
				}
				 if(user.getSalary()!=0.0) {
					 user2.setSalary(user.getSalary()); 
				 }
				 if(user.getGender()!=Character.MIN_VALUE) {
					 user2.setGender(user.getGender());
				 }
				 User resultUser = userRepository.save(user2);
				isUserUpdated = true;
				System.out.println(resultUser);
			}	
		return isUserUpdated;

	}


	@Transactional
	public boolean deleteUserById(int id) {
		 boolean isUserDeleted=false;
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			isUserDeleted=true;
			System.out.println("Entry Deleted");
			return isUserDeleted;
		} else {
			System.out.println("User Not Exist");
			return isUserDeleted;
		}
	}

}
