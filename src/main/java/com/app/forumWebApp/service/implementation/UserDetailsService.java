/**
 * 
 */
package com.app.forumWebApp.service.implementation;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Shubhashish PC
 *
 */
public interface UserDetailsService {
	UserDetails loadUserByUsername(String username)	throws UsernameNotFoundException;

}
