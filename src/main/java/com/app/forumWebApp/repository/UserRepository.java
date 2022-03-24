/**
 * 
 */
package com.app.forumWebApp.repository;

import org.springframework.data.repository.CrudRepository;

import com.app.forumWebApp.entities.User;

/**
 * @author Shubhashish PC
 *
 */
public interface UserRepository extends CrudRepository<User, Long> {
	
	

}
