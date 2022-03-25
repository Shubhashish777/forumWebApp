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
public class Post implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6608407274705020728L;
	
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
	
	
	
	

}
