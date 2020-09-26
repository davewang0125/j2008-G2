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
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/api")
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
	
    @GetMapping("/")
    public String notRestricted() {
        return "need login!";
    }
    
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
    	log.info("UserId {} UserName {} FirstName {} LastName {} Email {}", user.getUserId().toString(), user.getUserName(), user.getFirstName(), user.getLastName(), user.getEmail() );

		return userService.saveUser(user);
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
	
	@GetMapping("/User/{user_name}")
	@ApiOperation("find user by username")
	public User findUserByName(@PathVariable String user_name) {
		List<User> users = userRepository.findAll();
		for(User user: users) { 
			if(user.getUserName().equals(user_name)) {
				return user;
			}
		}
		throw new UserNotFoundException("User not found :: " + user_name);
	}
	
	@PutMapping("/Users/{id}")
	@ApiOperation("update user profile")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Integer userId,
	        			   @Valid @RequestBody User userDetails)  throws UserNotFoundException {
		User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found :: " + userId));
	        user.setEmail(userDetails.getEmail());
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

    @PostMapping("/User/{id}/addAsset")  // asset add userId ???
	@ApiOperation("Add an asset")
	public Asset addAsset(@RequestBody Asset asset, @PathVariable(value = "id") Integer userId) {
    	log.info("AssetId {} Audio {} Tanscript {} Translation {}", asset.getAsset_id().toString(), asset.getAudio(), asset.getTranscript(), asset.getTranslation() );
    	User user = userRepository.findById(userId)
	            .orElseThrow(() -> new UserNotFoundException("User not found :: " + userId));
    	user.addAsset(asset);
		return assetService.saveAsset(asset);
	}
	
	@GetMapping("/User/{id}/Assets")
	@ApiOperation("list all assets by userid")
	public ResponseEntity<List<Asset>> findAssetsById(@PathVariable(value = "id") Integer UserId) throws UserNotFoundException { 
		User user = userRepository.findById(UserId)
	            .orElseThrow(() -> new UserNotFoundException("User not found :: " + UserId));
		List<Asset> assets = user.getAssets();
	    return ResponseEntity.ok().body(assets);
	}
	
	@DeleteMapping("/User/{id}/Asset/{asse_id}")
	@ApiOperation("delete asset")
	public Map<String, Boolean> deleteAsset(@PathVariable(value = "id") Integer UserId, @PathVariable(value = "asse_id") Integer id) throws UserNotFoundException {
		User user = userRepository.findById(UserId)
	            .orElseThrow(() -> new AssetNotFoundException("Assets not found :: " + UserId));    
		List<Asset> assets = user.getAssets();
		boolean found = false;
	    for(Asset a: assets) {
	    	if(a.getAsset_id() == id) {
	    		assetRepository.delete(a);
	    		found = true;
	    	}
	    } 
	    if(found == false) {
		    throw new AssetNotFoundException("Assets not found :: " + id);
	    }
        Map<String, Boolean> response = new HashMap<> ();
        response.put("deleted", Boolean.TRUE);
        return response;
	}

}
