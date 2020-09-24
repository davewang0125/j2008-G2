package com.audio_translator.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.audio_translator.dao.AssetRepository;
import com.audio_translator.dao.UserRepository;
import com.audio_translator.entity.Asset;
import com.audio_translator.entity.User;
import com.audio_translator.exception.AssetNotFoundException;
import com.audio_translator.exception.UserNotFoundException;
import com.audio_translator.service.AssetService;
import com.audio_translator.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
//@RequestMapping("/api")
public class HomeController {
	
	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	AssetService assetService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired 
	AssetRepository assetRepository;
	
	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public String messageNotReadable(HttpMessageNotReadableException exception, HttpServletResponse response){
	    log.error("request parameter not valid", exception);
	    return "";
	}
	
	@PostMapping("/addUser") 
	@ApiOperation("Add an user")
	public User addUser(@RequestBody User user) {
    	log.info("UserId {} FirstName {} LastName {} Email {}", user.getUserId().toString(), user.getFirstName(), user.getLastName(), user.getEmail() );

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
	public ResponseEntity<User> findUserById(@PathVariable(value = "id") Integer userId) throws UserNotFoundException {
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found :: " + userId));
	    return ResponseEntity.ok().body(user);
	}
	
//	@GetMapping("/User/{name}")
//	@ApiOperation("find user by name")
//	public User findUserByName(@PathVariable String name) {
//		return userService.getUserByName(name);
//	}
	
	@PutMapping("/Users/{id}")
	@ApiOperation("update user")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
	        			   @Valid @RequestBody User userDetails)  throws UserNotFoundException {
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found :: " + userId));
	        //user.setEmail(userDetails.getEmail());
	    final User updatedUser = userRepository.save(user);
	    return ResponseEntity.ok(updatedUser);
	}
	
	@DeleteMapping("/Users/{id}")
	@ApiOperation("delete user")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") int userId) throws UserNotFoundException {
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found :: " + userId));

	    userRepository.delete(user);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

    @GetMapping("/")
    public String notRestricted() {
        return "need login!";
    }

//    @GetMapping("/restricted")
//    public String restricted() {
//        return "if you see this you are logged in";
//    }
	
//	@RequestMapping(value = "/") // <2>
//	public String index() {
//		return "index"; // <3>
//	}

    @PostMapping("/addAsset") 
	@ApiOperation("Add an asset")
	public Asset addAsset(@RequestBody Asset asset) {
    	log.info("Id {} Audio {} Tanscript {} Translation {}", asset.getId().toString(), asset.getAudio(), asset.getTranscript(), asset.getTranslation() );

		return assetService.saveAsset(asset);
	}
	
	@GetMapping("/assetById/{id}")
	@ApiOperation("find assets by id")
	public ResponseEntity<List<Asset>> findAssetsById(@PathVariable(value = "id") Integer id) throws UserNotFoundException {
	        List<Asset> assets = (List<Asset>) assetRepository.findById(id)
	            .orElseThrow(() -> new AssetNotFoundException("Assets not found :: " + id));
	    return ResponseEntity.ok().body(assets);
	}
	
	@DeleteMapping("/Assets/{id}")
	@ApiOperation("delete assets")
	public Map<String, Boolean> deleteAssets(@PathVariable(value = "id") int id) throws UserNotFoundException {
	        Asset asset = assetRepository.findById(id)
	            .orElseThrow(() -> new AssetNotFoundException("User not found :: " + id));

	    assetRepository.delete(asset);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

}
