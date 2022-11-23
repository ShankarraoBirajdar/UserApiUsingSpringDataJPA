package com.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.data.jpa.entities.Registration;

@Repository
public interface RegistrationRepository extends CrudRepository<Registration, Integer> {

	
	//Custom Method in SpringDataJPA
		//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods.details
		public List<Registration> findByGender(String gender);
		public List<Registration> findByEmail(String email);
		
		//Custom Method Using JPQL
		@Query("select u FROM Registration u")
		public List<Registration> getAllUsersUsingJPQL();
		
	    //Custom Method Using JPQL
//		@Query("select u FROM Registration u WHERE u.firstname=:n and u.gender=:c")
//		public List<Registration> getUserByName(@Param("n") String firstName,@Param("c") String gender);
		
		//Custom Method Using Native SQL Query
		@Query(value = "select * from Registration",nativeQuery = true)
		public List<Registration> getAllUsersUsingNativeSQLQuery();
}
