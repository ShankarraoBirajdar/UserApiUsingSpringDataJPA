package com.spring.data.jpa.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.spring.data.jpa.entities.Registration;


public class RegistrationRepositoryImpl {

	public static void getAllUsers(RegistrationRepository repository) {

		Iterable<Registration> result = repository.findAll();

		result.forEach(user -> System.out.println(user));
	}

	public static void getUserById(int id, RegistrationRepository repository) {

		if (repository.existsById(id)) {
			Optional<Registration> optional = repository.findById(id);
			Registration user = optional.get();
			System.out.println(user);
		} else {
			System.out.println("User Not Exist");
		}

	}
	
	
	// Custom Method in SpringDataJPA
		public static void getUsersByGender(String gender, RegistrationRepository repository) {
			List<Registration> result = repository.findByGender(gender);
			result.forEach(user -> System.out.println(user));
		}

		// Custom Method in SpringDataJPA
		public static void getUsersBySalary(String email, RegistrationRepository repository) {
			List<Registration> result = repository.findByEmail(email);
			result.forEach(user -> System.out.println(user));
		}

		public static void delete(int id, RegistrationRepository repository) {
			if (repository.existsById(id)) {
				repository.deleteById(id);
				System.out.println("Entry Deleted");
			} else {
				System.out.println("User Not Exist");
			}
		}
		
		public static void update(int id, RegistrationRepository repository, Registration user) {
			if (repository.existsById(id)) {
				Optional<Registration> optional = repository.findById(id);
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
				Registration resultUser = repository.save(user2);
				System.out.println(resultUser);
			} else {
				System.out.println("User Not Exist");
			}
		}
}
