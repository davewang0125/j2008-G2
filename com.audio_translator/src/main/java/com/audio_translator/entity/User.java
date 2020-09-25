package com.audio_translator.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@Column(name = "user_id")
	//@GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
	private Integer userId;
	
	@Column(name="user_name")
	private String userName;
	
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

	@JsonBackReference
	@OneToMany(cascade= {CascadeType.ALL},fetch = FetchType.LAZY, targetEntity=Asset.class, mappedBy="user")  // 'user' is table name in One
	private List<Asset> assets;
	
	//add convenience methods for bi-directional relationship
	public void addAsset(Asset asset) {
		if(assets == null) {
			assets = new ArrayList<>();
		}
		assets.add(asset);
		asset.setUser(this);
	}
	
	public User(String userName, String firstName, String lastName, String email, String loginSource, LocalDateTime lastlogin) {
		this.userName = userName;
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
			Objects.equals(userName, user.userName) &&
			Objects.equals(firstName, user.firstName) &&
			Objects.equals(lastName, user.lastName) &&
			Objects.equals(email, user.email) &&
			Objects.equals(loginSource, user.loginSource) &&
			Objects.equals(lastlogin, user.lastlogin);
	}

	@Override
	public int hashCode() {

		return Objects.hash(userId, userName, firstName, lastName, email, loginSource);
	}

	@Override
	public String toString() {
		return "user{" +
			"id=" + userId +
			"userName=" + userName +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", email='" + email + '\'' +
			", loginSource='" + loginSource + '\'' +
			", loginSolastloginurce='" + lastlogin + '\'' +
			'}';
	}
}
