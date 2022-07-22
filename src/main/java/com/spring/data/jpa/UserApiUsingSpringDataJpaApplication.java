package com.spring.data.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.spring.data.jpa.controller.*;

@SpringBootApplication
public class UserApiUsingSpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApiUsingSpringDataJpaApplication.class, args);
	}

}
