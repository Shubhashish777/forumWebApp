/**
 * 
 */
package com.app.forumWebApp.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.lang.NonNull;

/**
 * @author Shubhashish PC
 *
 */

@Entity
public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3418146846104388894L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long UserId;
	private String UserName;
	@Column(unique=true)
	private String UserEmail;
	private Instant UserAccountCreationDate;
	private Long UserPostCount;
	private Long UserCommentCount;
	private ArrayList<Comment> CommentList;
	private ArrayList<Post> PostList;
	
	
	
	
	
	public Long getUserId()
	
	{
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
	public Instant getUserAccountCreationDate() {
		return UserAccountCreationDate;
	}
	@PrePersist
	public void setUserAccountCreationDate() {
		UserAccountCreationDate =  Instant.now();
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
	public ArrayList<Comment> getCommentList() {
		return CommentList;
	}
	public void setCommentList(ArrayList<Comment> commentList) {
		CommentList = commentList;
	}
	public ArrayList<Post> getPostList() {
		return PostList;
	}
	public void setPostList(ArrayList<Post> postList) {
		PostList = postList;
	}
	
	
	
	
	
	

	

}
