package cst438_FinalProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cst438_FinalProject.repository.*;
import cst438_FinalProject.domain.*;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	

	
	private boolean existingUser;
	
	public User getUser(LoginUser loginUser) {
		User user;
		String email = loginUser.getEmail();
		List<User> users = userRepository.findByEmail(email);
		//User already exists
		if ( users.size()>0) {
			user = users.get(0);
//			System.out.println("User already Exists");
			existingUser = true;
		//New User Detected
		} else {
			user = new User(loginUser);
//			System.out.println("New User detected");
			userRepository.save(user);
			existingUser = false;
		}
		return user;
	}
	
	public boolean existUser() {
		return existingUser;
	}
	

}
