/**
 * 
 */
package com.app.forumWebApp.repository;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.forumWebApp.entities.User;

/**
 * @author Shubhashish PC
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	
  	@Query("select u from User u where u.UserName = :UserName")
    User findByUsername(@Param("UserName") String UserName);
  	//Boolean existsByUsername(String username);
    //Boolean existsByEmail(String email);

}
