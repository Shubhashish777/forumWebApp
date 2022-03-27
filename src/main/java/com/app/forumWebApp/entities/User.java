/**
 * 
 */
package com.app.forumWebApp.entities;

import java.io.Serializable;
import javax.persistence.JoinColumn;
import java.sql.Date;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.forumWebApp.payload.UserDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/




/**
 * @author Shubhashish PC               
 *
 */

@Entity
public class User implements UserDetails{ // implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3418146846104388894L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long UserId;
	
	@Column(unique=true)
	@NotBlank
	@Size(max = 120)
	private String UserName;
	
	@NotBlank
	@Size(max = 120)
	@Column(unique=true)
	private String UserEmail;
	
	@NotBlank
	@Size(max = 120,min=10)
	private String password;
	

	private Instant UserAccountCreationDate;
	private Long UserPostCount;
	private Long UserCommentCount;

	private ArrayList<Long> CommentList;
	
	
	private ArrayList<Long> PostList;
	
	/*@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
		@JoinTable(
		    name = "User_Role",
		    joinColumns = @JoinColumn(name = "UserId"),
		    inverseJoinColumns = @JoinColumn(name = "id")
		)
	  private Set<Role> roles = new HashSet<>();*/
	
	
	
	public User()
	{
		
	}
	
	public User(UserDTO user)
	{
		this.password=user.getPassword();
		this.UserEmail=user.getUserEmail();
		this.UserName=user.getUserName();
		
	}
	

	public Long getUserId()
	{
		return UserId;
	}
	public void setUserAccountCreationDate(Instant userAccountCreationDate) {
		UserAccountCreationDate = userAccountCreationDate;
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

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	//public Set<Role> getRoles() {
	//	return roles;}

	/**
	 * @param roles the roles to set
	 */
	//public void setRoles(Set<Role> roles) {
	//	this.roles = roles;}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
	    return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.UserName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public ArrayList<Long> getCommentList() {
		return CommentList;
	}

	public void setCommentList(ArrayList<Long> commentList) {
		CommentList = commentList;
	}

	public ArrayList<Long> getPostList() {
		return PostList;
	}

	public void setPostList(ArrayList<Long> postList) {
		PostList = postList;
	}
	
	
	
	
	
	
	
	

	

}
