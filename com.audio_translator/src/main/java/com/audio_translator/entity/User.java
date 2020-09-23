package com.audio_translator.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//Userid, email, firstname, lastname, loginid, loginsource, lastlogin
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@NotNull
	@Column(name="user_firstname")
	private String firstName;
	
	@Column(name="user_lastname")
	private String lastName;
	
	@Column(name="user_email")
	private String email;
	
	@Column(name="loginsource")
	private String loginSource;
	
	@Column(name="lastlogin")
	private LocalDateTime lastlogin;

	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
	private Asset asset;
	
	public User(String firstName, String lastName, String email,String loginSource, LocalDateTime lastlogin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.loginSource = loginSource;
		this.lastlogin = LocalDateTime.now();
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
			Objects.equals(loginSource, user.loginSource) &&
			Objects.equals(lastlogin, user.lastlogin);
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
			", loginSolastloginurce='" + lastlogin + '\'' +
			'}';
	}
}
