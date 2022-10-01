package com.user.app.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer passengerId;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer age;
	private String mealOpted;
	private String seatNumber;
	private Integer PNRnumber;
	
	public Integer getPNRnumber() {
		return PNRnumber;
	}
	public void setPNRnumber(Integer pNRnumber) {
		PNRnumber = pNRnumber;
	}
	public String getMealOpted() {
		return mealOpted;
	}
	public void setMealOpted(String mealOpted) {
		this.mealOpted = mealOpted;
	}
	public String getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}
	public Integer getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	

}
