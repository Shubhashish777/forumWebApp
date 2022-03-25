/**
 * 
 */
package com.app.forumWebApp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.forumWebApp.entities.Comment;
import com.app.forumWebApp.service.CommentService;
import com.app.forumWebApp.service.UserService;
/**
 * @author Shubhashish PC
 *
 */
public class CommentController {
	
	@Autowired
	private CommentService CommentService;
	@Autowired
	private UserService UserService;
	
	//GET 
	
	
	

}
