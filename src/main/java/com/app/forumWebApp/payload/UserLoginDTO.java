/**
 * 
 */
package com.app.forumWebApp.payload;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Shubhashish PC
 *
 */
public class UserLoginDTO {
	
	@NotBlank
	@Size(max = 120)
	private String UserEmail;
	
	@NotBlank
	@Size(max = 120,min=10)
	private String password;

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
	
	
	

}
