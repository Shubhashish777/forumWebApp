/**
 * 
 */
package com.app.forumWebApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.forumWebApp.entities.User;

/**
 * @author Shubhashish PC
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
  	@Query("select u from User u where u.UserName = :UserName")
    User findByUsername(@Param("UserName") String UserName);
  	//Boolean existsByUsername(String username);
    //Boolean existsByEmail(String email);

}
