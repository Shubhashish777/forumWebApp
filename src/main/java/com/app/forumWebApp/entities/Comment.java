/**
 * 
 */
package com.app.forumWebApp.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Shubhashish PC
 *
 */
@Entity
public class Comment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6783293294277340296L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long commentId;
	private Long parentCommentId;
	private Long parentPostId;
	
	//How to sort Child comments efficiently and in real time?
	private ArrayList<Long> childCommentId;
	private Date creationDate;
	private Date lastUpdatedDate;
	private String content;
	
	
	
	
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getParentCommentId() {
		return parentCommentId;
	}
	public void setParentCommentId(Long parentCommentId) {
		this.parentCommentId = parentCommentId;
	}
	public ArrayList<Long> getChildCommentId() {
		return childCommentId;
	}
	public void setChildCommentId(ArrayList<Long> childCommentId) {
		this.childCommentId = childCommentId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
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
	public Long getParentPostId() {
		return parentPostId;
	}
	public void setParentPostId(Long parentPostId) {
		this.parentPostId = parentPostId;
	}
	
	
	
	
	
	
	
	

}
