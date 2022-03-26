/**
 * 
 */
package com.app.forumWebApp.payload;

import java.util.Set;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.app.forumWebApp.entities.Role;

/**
 * @author Shubhashish PC
 *
 */
public class UserDTO {
	

	@NotBlank
	@Size(max = 120)
	private String UserName;
	
	@NotBlank
	@Size(max = 120)
	private String UserEmail;
	
	@NotBlank
	@Size(max = 120,min=10)
	private String password;
	
	private Set<Role> roles; 
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return UserName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		UserName = userName;
	}

	/**
	 * @return the userEmail
	 */
	public String getUserEmail() {
		return UserEmail;
	}

	/**
	 * @param userEmail the userEmail to set
	 */
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}



}
