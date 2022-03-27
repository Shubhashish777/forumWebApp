package com.app.forumWebApp.controller;

import java.net.URI;
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
import com.app.forumWebApp.payload.PostDTO;
import com.app.forumWebApp.payload.UserDTO;
import com.app.forumWebApp.payload.UserLoginDTO;
import com.app.forumWebApp.payload.UserResponseDTO;
import com.app.forumWebApp.repository.PostRepository;
import com.app.forumWebApp.service.PostService;
import com.app.forumWebApp.service.UserService;

@RestController
public class PostController {
	
	 @Autowired
	 private AuthenticationManager authenticationManager;

	  @Autowired
	 private PasswordEncoder encoder;
	  @Autowired
	 private JwtUtils jwtUtils;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private PostRepository postRepo;
	
	
	//GET home
	@GetMapping("/home")
	public List<Post> getHome()
	{
		List<Post> post = postRepo.findlatestPosts(0);
		return post;
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("/user/board/{pageNo}")
	public List<Post> getBoardPage(@PathVariable int pageNo)
	{
		int offset=pageNo*10;
		List<Post> post = postRepo.findlatestPosts(offset);
		return post;
	}
	
	//GET Post by Id
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@GetMapping("user/post/{postId}")
	public PostDTO getPost(@PathVariable int postId)
	{
		Post post = postRepo.findbyPostId(postId);
		return new PostDTO(post);
		
	}
	
	
	
}
