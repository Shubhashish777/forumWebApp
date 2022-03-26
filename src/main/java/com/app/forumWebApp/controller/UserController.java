/**
 * 
 */
package com.app.forumWebApp.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.forumWebApp.entities.User;
import com.app.forumWebApp.payload.UserDTO;
import com.app.forumWebApp.service.UserService;

/**
 * @author Shubhashish PC
 *
 */

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	//GET User by id
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id)
	{
		User user = userService.getUser(id);
		return user;
		
	}
	
	
	//Create User 
	@PostMapping("/user/signup")
	public User createUser(@RequestBody @Valid UserDTO user)
	{
	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
		User newUser = userService.createUser(new User(user));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getUserId()).toUri();
		ResponseEntity.created(location).build();
		return newUser;
		
	}
	
	
	

}
