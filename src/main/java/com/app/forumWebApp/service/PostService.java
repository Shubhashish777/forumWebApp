/**
 * 
 */
package com.app.forumWebApp.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.forumWebApp.entities.Post;
import com.app.forumWebApp.entities.User;
import com.app.forumWebApp.payload.UserResponseDTO;
import com.app.forumWebApp.repository.PostRepository;

/**
 * @author Shubhashish PC
 *
 */
@Service
@Transactional
public class PostService {

	@Autowired
	PostRepository postRepo;
	
	
	public Post getPost (Long id)
	{
		Optional<Post> Post= postRepo.findById(id);
		return  Post.get();
		
	}
	
	public  Post createPost(Post post)
	{
		
		return postRepo.save(post);
	}
	
}
