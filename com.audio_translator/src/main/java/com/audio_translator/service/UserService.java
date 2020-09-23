package com.audio_translator.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public List<User> saveUsers(List<User> users) {
		return repository.saveAll(users);
	}
	
	public User getUserById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public List<User> getUsers() {
		return repository.findAll();
	}
	
//	public User getUserByName(String name) {
//		return repository.findByName(name);
//	}
	
	public String deleteUser(int id) {
		repository.deleteById(id);
		return "User " + id + " removed";
	}
	
	public User updateUser(User user) {
		User existingUser = repository.findById(user.getUserId()).orElse(null);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setLoginSource(user.getLoginSource());
		return repository.save(existingUser);
		
	}
}
