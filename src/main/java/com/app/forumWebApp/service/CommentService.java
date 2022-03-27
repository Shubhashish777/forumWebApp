/**
 * 
 */
package com.app.forumWebApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.forumWebApp.entities.Comment;
import com.app.forumWebApp.repository.CommentRepository;

/**
 * @author Shubhashish PC
 *
 */
@Service
public class CommentService {
	
	@Autowired 
	CommentRepository commentRepo;

	public Comment createComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepo.save(comment);
	}

}
