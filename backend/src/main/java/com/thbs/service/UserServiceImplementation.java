package com.thbs.service;

import java.util.Optional;
import java.security.SecureRandom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.thbs.config.JwtTokenProvider;
import com.thbs.exception.UserException;
import com.thbs.modal.User;
import com.thbs.repository.UserRepository;

//import jakarta.mail.MessagingException;

@Service
public class UserServiceImplementation implements UserService {
	
	 private UserRepository userRepository;
	    private JwtTokenProvider jwtTokenProvider;
	    
	    @Autowired
		 private BCryptPasswordEncoder passwordEncoder;
	    
	    @Autowired
		private SMTP_mailService mailService;
	    
	    public UserServiceImplementation(UserRepository userRepository, JwtTokenProvider jwtTokenProvider) {
	        this.userRepository = userRepository;
	        this.jwtTokenProvider = jwtTokenProvider;
	    }

	    @Override
	    public User findUserById(Long userId) throws UserException {
	        Optional<User> user = userRepository.findById(userId);
	        
	        if (user.isPresent()) {
	            return user.get();
	        }
	        throw new UserException("User not found with id " + userId);
	    }

	    @Override
	    public User findUserProfileByJwt(String jwt) throws UserException {
	        System.out.println("user service");
	        String email = jwtTokenProvider.getEmailFromJwtToken(jwt);
	        
	        System.out.println("email " + email);
	        
	        User user = userRepository.findByEmail(email);
	        
	        if (user == null) {
	            throw new UserException("User does not exist with email " + email);
	        }
	        System.out.println("email user " + user.getEmail());
	        return user;
	    }

	    @Override
	    public List<User> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public ResponseEntity<String> forgotPassword(String userEmail) {
	        User user = userRepository.findByEmail(userEmail);
	        if (user != null) {
	            String newPassword = PasswordGenerator(); // Generate a new random password
	            String encodedPassword = passwordEncoder.encode(newPassword); // Encode the new password

	            user.setPassword(encodedPassword); // Set the encoded password

	            try {
	                mailService.sendMailService(userEmail, "Password Changed", "Your new Password is : " + newPassword);
	                userRepository.save(user); // Save the user with the new encoded password
	                return new ResponseEntity<>("New password has been sent to the user's email", HttpStatus.ACCEPTED);
	            } catch (Exception e) {
	                throw new RuntimeException(e);
	            }
	        } else {
	            return new ResponseEntity<>("User with this email not found", HttpStatus.NOT_FOUND);
	        }
	    }
	    
		public String PasswordGenerator() {
	        String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	        String numbers = "1234567890";
	        String characters = alpha + numbers;
	        SecureRandom random = new SecureRandom();
	        StringBuilder password = new StringBuilder();
	        for (int i = 0; i < 8; i++) {
	            int index = random.nextInt(characters.length());
	            password.append(characters.charAt(index));
	        }
	        return password.toString();
	    }
}
