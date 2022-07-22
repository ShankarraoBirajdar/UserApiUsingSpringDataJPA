package com.spring.data.jpa.repository;

import java.util.List;
import java.util.Optional;

import com.spring.data.jpa.entities.User;

public class UserRepositoryImpl {

	public static void getAllUsers(UserRepository repository) {

		Iterable<User> result = repository.findAll();

		result.forEach(user -> System.out.println(user));
	}

	public static void getUserById(int id, UserRepository repository) {

		if (repository.existsById(id)) {
			Optional<User> optional = repository.findById(id);
			User user = optional.get();
			System.out.println(user);
		} else {
			System.out.println("User Not Exist");
		}

	}

	// Custom Method in SpringDataJPA
	public static void getUsersByGender(char gender, UserRepository repository) {
		List<User> result = repository.findByGender(gender);
		result.forEach(user -> System.out.println(user));
	}

	// Custom Method in SpringDataJPA
	public static void getUsersBySalary(double salary, UserRepository repository) {
		List<User> result = repository.findBySalary(salary);
		result.forEach(user -> System.out.println(user));
	}

	public static void delete(int id, UserRepository repository) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			System.out.println("Entry Deleted");
		} else {
			System.out.println("User Not Exist");
		}
	}

	public static void update(int id, UserRepository repository, String name, char gender, double salary) {
		if (repository.existsById(id)) {
			Optional<User> optional = repository.findById(id);
			User user = optional.get();
			user.setName(name);
			user.setGender(gender);
			user.setSalary(salary);
			User resultUser = repository.save(user);
			System.out.println(resultUser);
		} else {
			System.out.println("User Not Exist");
		}
	}

	public static void saveListOfObject(UserRepository repository) {
		User user1 = new User();
		user1.setName("FirstName LastName");
		user1.setGender('F');
		user1.setSalary(10000);

		User user2 = new User();
		user2.setName("FirstName LastName");
		user2.setGender('M');
		user2.setSalary(12000);

		// save List of Objects
		List<User> users = List.of(user1, user2);
		Iterable<User> result = repository.saveAll(users);

		result.forEach(user -> {
			System.out.println(user);
		});
	}

	public static void saveSingelObject(UserRepository repository, String name, char gender, double salary) {
		User user = new User();
		user.setName(name);
		user.setGender(gender);
		user.setSalary(salary);

		// save single Object
		User result = repository.save(user);
		System.out.println(result);
	}

}
