package com.audio_translation.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue
	private int userId;
	
	private String firstName;
	private String lastName;
	private String email;
	private String loginSource;
	//private String 
	
	private String description;

	public User(String firstName, String lastName, String email,String loginSource) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.loginSource = loginSource;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return Objects.equals(userId, user.userId) &&
			Objects.equals(firstName, user.firstName) &&
			Objects.equals(lastName, user.lastName) &&
			Objects.equals(email, user.email) &&
			Objects.equals(loginSource, user.loginSource);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, firstName, lastName, email, loginSource);
	}

	@Override
	public String toString() {
		return "user{" +
			"id=" + userId +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			", loginSource='" + loginSource + '\'' +
			'}';
	}
}
