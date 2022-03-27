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
	private String UserName;
	
	@NotBlank
	@Size(max = 120,min=10)
	private String password;

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
