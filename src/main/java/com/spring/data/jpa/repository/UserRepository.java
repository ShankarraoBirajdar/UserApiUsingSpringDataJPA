package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
	//Custom Method in SpringDataJPA
	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
	public List<User> findByGender(char gender);
	public List<User> findBySalary(double salary);
	
	//Custom Method Using JPQL
	@Query("select u FROM User u")
	public List<User> getAllUsersUsingJPQL();
	
    //Custom Method Using JPQL
	@Query("select u FROM User u WHERE u.name=:n and u.gender=:c")
	public List<User> getUserByName(@Param("n") String name,@Param("c") char gender);
	//Custom Method Using Native SQL Query
	@Query(value = "select * from User",nativeQuery = true)
	public List<User> getAllUsersUsingNativeSQLQuery();

	
}
