/**
 * 
 */
package com.app.forumWebApp.entities; 

import java.io.Serializable;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import net.minidev.json.annotate.JsonIgnore;

/**
 * @author Shubhashish PC
 *
 */
@Entity
public class Post implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6608407274705020728L;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long postId;
	
	 @ManyToOne(fetch = FetchType.EAGER, optional = false)
	 @JoinColumn(name = "UserId", nullable = false)
	 @OnDelete(action = OnDeleteAction.CASCADE)
	 @JsonIgnore
     private User user;
	 
	 private Instant creationDate;
	 private Date lastUpdatedDate;
	 @NotNull
	 private String content;
	 @NotNull
	 private String title;
	 
	 private ArrayList<Long> CommentList;
	 
	 
	 
	/**
	 * @return the postId
	 */
	public Long getPostId() {
		return postId;
	}
	/**
	 * @param postId the postId to set
	 */
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the creationDate
	 */
	public Instant getCreationDate() {
		return creationDate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@PrePersist
	public void setCreationDate() {
		this.creationDate = Instant.now();
	}
	/**
	 * @return the lastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	public ArrayList<Long> getCommentList() {
		return CommentList;
	}
	public void setCommentList(ArrayList<Long> commentList) {
		CommentList = commentList;
	}
	 
	 


}
