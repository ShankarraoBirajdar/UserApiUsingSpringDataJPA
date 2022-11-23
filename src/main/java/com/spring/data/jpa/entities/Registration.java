package com.spring.data.jpa.entities;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registration")
public class Registration implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "userId")
	int id;
	@Column(name = "firstName")
	String firstName;
	@Column(name = "middleName")
	String middleName;
	@Column(name = "lastName")
	String lastName;
	@Column(name = "email")
	String email;
	@Column(name = "address")
	String address;
	@Column(name = "dob")
	String dateOfBirth;
	@Column(name = "country")
	String country;
	@Column(name = "language")
	String language;
	@Column(name = "gender")
	String gender;
	@Column(name = "image")
	String image;
	
	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Registration(int id, String firstName, String middleName, String lastName, String email, String address,
			String dateOfBirth, String country, String language, String gender, String image) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.country = country;
		this.language = language;
		this.gender = gender;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", email=" + email + ", address=" + address + ", dateOfBirth=" + dateOfBirth + ", country="
				+ country + ", language=" + language + ", gender=" + gender + ", image=" + image + "]";
	}



	
	
}
