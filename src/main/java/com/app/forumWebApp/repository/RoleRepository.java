/**
 * 
 */
package com.app.forumWebApp.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.forumWebApp.entities.Role;
import com.app.forumWebApp.entities.UserRole;

/**
 * @author Shubhashish PC
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
	 Optional<Role> findByName(UserRole role);

}
