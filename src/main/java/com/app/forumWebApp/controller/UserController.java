/**
 * 
 */
package com.app.forumWebApp.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.forumWebApp.Responses.MessageResponse;
import com.app.forumWebApp.config.AuthEntryPointJwt;
import com.app.forumWebApp.config.JwtUtils;
import com.app.forumWebApp.entities.Post;
import com.app.forumWebApp.entities.User;
import com.app.forumWebApp.payload.UserDTO;
import com.app.forumWebApp.payload.UserLoginDTO;
import com.app.forumWebApp.payload.UserResponseDTO;
import com.app.forumWebApp.service.PostService;
import com.app.forumWebApp.service.UserService;

/**
 * @author Shubhashish PC
 *
 */

@RestController
public class UserController {
	
	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	 @Autowired
	  AuthenticationManager authenticationManager;

	  @Autowired
	  PasswordEncoder encoder;
	  @Autowired
	  JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	
	//GET User by id
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/user/{id}")
	public UserResponseDTO getUser(@PathVariable Long id)
	{
		UserResponseDTO user = userService.getUser(id);
		return user;
		
	}
	
	
	//Create User & Registration
	@PostMapping("/user/signup")
	public User createUser(@RequestBody @Valid UserDTO user)
	{
	
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	    String encodedPassword = passwordEncoder.encode(user.getPassword());
	    user.setPassword(encodedPassword);
		User newUser = userService.createUser(new User(user));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getUserName()).toUri();
		ResponseEntity.created(location).build();
		return newUser;
		
	}
	
	//Login User
	@PostMapping("/user/signin")
	  public ResponseEntity<MessageResponse> authenticateUser(@Valid @RequestBody UserLoginDTO loginRequest) {
		
 

		jwtUtils.getCleanJwtCookie();
	    Authentication authentication = authenticationManager
	        .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
	    SecurityContextHolder.getContext().setAuthentication(authentication);
	    User userDetails = (User) authentication.getPrincipal();
	    ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);
	    List<String> roles = userDetails.getAuthorities().stream()
	        .map(item -> item.getAuthority())
	        .collect(Collectors.toList());
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
	            .body(new MessageResponse(userDetails.getUsername()+", You've been logged in"));
	    
	    //return userDetails;
	  }

	
	
	  //LogOut User
	  @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	  @PostMapping("/user/signout")
	  public ResponseEntity<MessageResponse> logoutUser() {
	    ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
	    
	    
	    return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
	        .body(new MessageResponse("You've been signed out!"));
	  }
	
	  
	  
	    //Create Posts
		@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
		@PostMapping("/user/post")
		public Post createPost(@RequestBody  Post post)
		{
			User currentUser= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			post.setUser(currentUser);
			Post newPost= postService.createPost(post);
			ArrayList<Long>temp=currentUser.getPostList();
			if (temp==null)
			{
				temp= new ArrayList<Long>();
			}
			temp.add(newPost.getPostId());
			currentUser.setPostList(temp);
			userService.createUser(currentUser);
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{UserId}/{id}").buildAndExpand(currentUser.getUserName(),newPost.getPostId()).toUri();
			ResponseEntity.created(location).build();
			return newPost;	
		}
		
	
		
	

}
