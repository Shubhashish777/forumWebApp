/**
 * 
 */
package com.app.forumWebApp.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.forumWebApp.entities.Comment;
import com.app.forumWebApp.entities.Post;
import com.app.forumWebApp.entities.User;
import com.app.forumWebApp.service.CommentService;
import com.app.forumWebApp.service.UserService;
/**
 * @author Shubhashish PC
 *
 */
@RestController
public class CommentController {
	
	@Autowired
	private CommentService CommentService;
	@Autowired
	private UserService UserService;
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/user/post/{postId}/comment")
	public Comment createComment(@PathVariable Long postId, @RequestBody  Comment comment)
	{
		User currentUser= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		comment.setUserId(currentUser.getUserName());
		comment.setParentPostId(postId);
		Comment newComment= CommentService.createComment(comment);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{UserId}/{id}").buildAndExpand(currentUser.getUserName(),newPost.getPostId()).toUri();
		//ResponseEntity.created(location).build();
		return newComment;	
	}
	
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	@PostMapping("/user/post/{postId}/comment/{commentId}")
	public Comment createReplies(@PathVariable Long postId, @RequestBody  Comment comment)
	{
		User currentUser= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		comment.setUserId(currentUser.getUserName());
		comment.setParentPostId(postId);
		Comment newComment= CommentService.createComment(comment);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{UserId}/{id}").buildAndExpand(currentUser.getUserName(),newPost.getPostId()).toUri();
		//ResponseEntity.created(location).build();
		return newComment;	
	}
	
	
	
	
	

}
