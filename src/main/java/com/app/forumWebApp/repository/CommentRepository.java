/**
 * 
 */
package com.app.forumWebApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.forumWebApp.entities.Comment;

/**
 * @author Shubhashish PC
 *
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {

}
