/**
 * 
 */
package com.app.forumWebApp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Shubhashish PC
 *
 */


@Entity
public class Role {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  @Enumerated(EnumType.STRING)
	  @Column(length = 20)
	  private UserRole name;
	  
	  public Role() {
			
		}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	public Role(Long id, UserRole name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public UserRole getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(UserRole name) {
		this.name = name;
	}
	
	  

}
