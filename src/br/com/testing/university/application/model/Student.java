package br.com.testing.university.application.model;

import br.com.testing.university.application.enums.Gender;

/**
 * The class represents a student entity
 * @author Daivid
 *
 */
public class Student {

	private String name;
	private int age;
	private Gender gender;
	private String email;
	private int registrationNumber;
	
	public Student(String name, int age, Gender gender) {
		
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(int registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
}