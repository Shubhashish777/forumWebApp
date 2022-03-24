/**
 * 
 */
package com.app.forumWebApp.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Shubhashish PC
 *
 */

@Entity
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long UserId;
	private String UserName;
	@Column(unique=true)
	private String UserEmail;
	private Date UserAccountCreationDate;
	private Long UserPostCount;
	private Long UserCommentCount;
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getUserEmail() {
		return UserEmail;
	}
	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}
	public Date getUserAccountCreationDate() {
		return UserAccountCreationDate;
	}
	public void setUserAccountCreationDate(Date userAccountCreationDate) {
		UserAccountCreationDate = userAccountCreationDate;
	}
	public Long getUserPostCount() {
		return UserPostCount;
	}
	public void setUserPostCount(Long userPostCount) {
		UserPostCount = userPostCount;
	}
	public Long getUserCommentCount() {
		return UserCommentCount;
	}
	public void setUserCommentCount(Long userCommentCount) {
		UserCommentCount = userCommentCount;
	}
	
	
	
	
	
	

	

}
