/**
 * 
 */
package com.app.forumWebApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.forumWebApp.entities.Post;

/**
 * @author Shubhashish PC
 *
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	
	@Query(value= "SELECT * FROM Post p ORDER BY post_Id DESC LIMIT 10 OFFSET ?1",nativeQuery = true)
	List<Post> findlatestPosts(int off);
	
	@Query(value= "SELECT * FROM Post p where p.post_id= ?1",nativeQuery = true)
	Post findbyPostId(int id);
	
	

}
