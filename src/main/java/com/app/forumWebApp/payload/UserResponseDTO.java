/**
 * 
 */
package com.app.forumWebApp.payload;

import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.app.forumWebApp.entities.Comment;
import com.app.forumWebApp.entities.User;
import com.app.forumWebApp.entities.Post;

/**
 * @author Shubhashish PC
 *
 */
public class UserResponseDTO {
	

	private String UserName;
	private Instant UserAccountCreationDate;
	private Long UserPostCount;
	private Long UserCommentCount;
	private ArrayList<Long> CommentList;
	private ArrayList<Long> PostList;
	
	
	
	public UserResponseDTO(User user)
	{
	
		this.UserName=user.getUsername();
		this.UserAccountCreationDate=user.getUserAccountCreationDate();
		this.UserPostCount=user.getUserPostCount();
		this.UserCommentCount=user.getUserCommentCount();
		this.CommentList=user.getCommentList();
		this.PostList=user.getPostList();
	}
	
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
	 * @return the userAccountCreationDate
	 */
	public Instant getUserAccountCreationDate() {
		return UserAccountCreationDate;
	}
	/**
	 * @param userAccountCreationDate the userAccountCreationDate to set
	 */
	public void setUserAccountCreationDate(Instant userAccountCreationDate) {
		UserAccountCreationDate = userAccountCreationDate;
	}
	/**
	 * @return the userPostCount
	 */
	public Long getUserPostCount() {
		return UserPostCount;
	}
	/**
	 * @param userPostCount the userPostCount to set
	 */
	public void setUserPostCount(Long userPostCount) {
		UserPostCount = userPostCount;
	}
	/**
	 * @return the userCommentCount
	 */
	public Long getUserCommentCount() {
		return UserCommentCount;
	}
	/**
	 * @param userCommentCount the userCommentCount to set
	 */
	public void setUserCommentCount(Long userCommentCount) {
		UserCommentCount = userCommentCount;
	}
	/**
	 * @return the commentList
	 */
	public ArrayList<Long> getCommentList() {
		return CommentList;
	}
	/**
	 * @param commentList the commentList to set
	 */
	public void setCommentList(ArrayList<Long> commentList) {
		CommentList = commentList;
	}
	/**
	 * @return the postList
	 */
	public ArrayList<Long> getPostList() {
		return PostList;
	}
	/**
	 * @param postList the postList to set
	 */
	public void setPostList(ArrayList<Long> postList) {
		PostList = postList;
	}
	
	

}
