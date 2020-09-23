package com.audio_translation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.audio_translation.entity.User;
import com.audio_translation.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/addUser")
	@ApiOperation("Add an user")
	public User addUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PostMapping("/addUsers")
	@ApiOperation("Add a list of users")
	public List<User> addUsers(@RequestBody List<User> users) {
		return userService.saveUsers(users);
	}
	
	@GetMapping("/Users")
	@ApiOperation("list all users")
	public List<User> findAllUsers() {
		return userService.getUsers();
	}
	
	@GetMapping("/userById/{id}")
	@ApiOperation("find user by id")
	public User findUserById(@PathVariable int id) {
		return userService.getUserById(id); 
	}
	
	@GetMapping("/User/{name}")
	@ApiOperation("find user by name")
	public User findUserByName(@PathVariable String name) {
		return userService.getUserByName(name);
	}
	
	@PutMapping
	@ApiOperation("update user")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	
	@DeleteMapping
	@ApiOperation("delete user")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUser(id);
	}

//    @GetMapping("/not-restricted")
//    public String notRestricted() {
//        return "you don't need to be logged in";
//    }
//
//    @GetMapping("/restricted")
//    public String restricted() {
//        return "if you see this you are logged in";
//    }
    
    

    
	
//	@RequestMapping(value = "/") // <2>
//	public String index() {
//		return "index"; // <3>
//	}

}
