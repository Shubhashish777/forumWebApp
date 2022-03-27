/**
 * 
 */
package com.app.forumWebApp.payload;

import java.sql.Date;
import java.time.Instant;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.app.forumWebApp.entities.Post;
import com.app.forumWebApp.entities.User;

import net.minidev.json.annotate.JsonIgnore;

/**
 * @author Shubhashish PC
 *
 */
public class PostDTO {


	 private Long postId;	
	 private String UserName;
	 private Instant creationDate;
	 private Date lastUpdatedDate;
	 @NotNull
	 private String content;
	 @NotNull
	 private String title;
	 
	 public PostDTO(Post post)
	 {
		 this.postId=post.getPostId();
		 this.UserName=post.getUser().getUserName();
		 this.creationDate=post.getCreationDate();
		 this.lastUpdatedDate=post.getLastUpdatedDate();
		 this.content=post.getContent();
		 this.title=post.getTitle();
	 }

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public Instant getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Instant creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	 
	 
}
