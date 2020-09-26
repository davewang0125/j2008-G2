package com.audio_translator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Application {

//	@Autowired 
//	private UserRepository userRepository;
//	
//	@Autowired
//	private AssetRepository assetRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	public void run(String... args) throws Exception {
//        // Clean up database tables
////		AssetRepository.deleteAllInBatch();
////        UserRepository.deleteAllInBatch();
//
//        //=========================================
//
//        // Create a User instance
//        User user = new User("Dave", "Wang", "davewang@github.com",
//                "gmail", LocalDateTime.now());
//
//        Calendar dateOfBirth = Calendar.getInstance();
//        dateOfBirth.set(1992, 7, 21);
//
//        // Create a UserProfile instance
//        Asset asset = new Asset(".....audio", "....transcript", "....translation",
//                "12345", "content",  LocalDateTime.now());
//
//
//        // Set child reference(userProfile) in parent entity(user)
//        user.setAsset(asset);
//
//        // Set parent reference(user) in child entity(userProfile)
//        asset.setUser(user);
//
//        // Save Parent Reference (which will save the child as well)
//        userRepository.save(user);
//
//        //=========================================
//    }
}
