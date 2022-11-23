package com.spring.data.jpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.data.jpa.entities.Registration;
import com.spring.data.jpa.repository.RegistrationRepository;

@Service
public class RegistartionService {
	@Autowired
	private RegistrationRepository registrationRepository;
	
	public List<Registration> getAllUser() {
		List<Registration> users = (List<Registration>) registrationRepository.findAll();
		return users;
	}

	public Registration getUserById(int id) {
		if (registrationRepository.existsById(id)) {
			Optional<Registration> optional = registrationRepository.findById(id);
			Registration user = optional.get();
			System.out.println(user);
			return user;
		} else {
			System.out.println("User Not Exist");
			return null;
		}

	}
	
	@Transactional
	public boolean addUser( Registration user) {
		boolean isUserCreated=false;
		if(user!=null) {
			// save single Object
			Registration result = registrationRepository.save(user);
			isUserCreated=true;
			System.out.println(result);
			return isUserCreated;
		}
		else {
			return isUserCreated;
		}

	}
	
	@Transactional
	public boolean updateUserUsingPut(int id,Registration user) {
		boolean isUserUpdated=false;
		if (registrationRepository.existsById(id)) {
			Optional<Registration> optional = registrationRepository.findById(id);
			Registration user2 = optional.get();
			user2.setFirstName(user.getFirstName());
			user2.setMiddleName(user.getMiddleName());
			user2.setLastName(user.getLastName());
			user2.setEmail(user.getEmail());
			user2.setAddress(user.getAddress());
			user2.setDateOfBirth(user.getDateOfBirth());
			user2.setCountry(user.getCountry());
			user2.setLanguage(user.getLanguage());
			user2.setGender(user.getGender());
			user2.setImage(user.getImage());
			Registration resultUser = registrationRepository.save(user2);
			isUserUpdated=true;
			System.out.println(resultUser);
			
		}
		return isUserUpdated;
	}
	
	@Transactional
	public boolean deleteUserById(int id) {
		 boolean isUserDeleted=false;
		if (registrationRepository.existsById(id)) {
			registrationRepository.deleteById(id);
			isUserDeleted=true;
			System.out.println("Entry Deleted");
			return isUserDeleted;
		} else {
			System.out.println("User Not Exist");
			return isUserDeleted;
		}
	}

}
