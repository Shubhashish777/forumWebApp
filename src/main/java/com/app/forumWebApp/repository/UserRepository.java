/**
 * 
 */
package com.app.forumWebApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.forumWebApp.entities.User;

/**
 * @author Shubhashish PC
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
