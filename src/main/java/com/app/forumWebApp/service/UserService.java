/**
 * 
 */
package com.app.forumWebApp.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.forumWebApp.entities.User;
import com.app.forumWebApp.repository.UserRepository;

/**
 * @author Shubhashish PC
 *
 */
@Service
public class UserService {
	
	
	@Autowired
	private UserRepository userRepo;
	
	
	public User getUser (Long id)
	{
		Optional<User> User= userRepo.findById(id);
		return User.get();
		
	}
	
	public User createUser(User user)
	{
		
		
		return userRepo.save(user);
	}
	

}
