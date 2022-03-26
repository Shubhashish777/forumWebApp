/**
 * 
 */
package com.app.forumWebApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.forumWebApp.entities.Comment;

/**
 * @author Shubhashish PC
 *
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
