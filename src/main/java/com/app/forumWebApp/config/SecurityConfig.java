/**
 * 
 */
package com.app.forumWebApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Shubhashish PC
 *
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	    //Public API for user registration
	    @Override
	    protected void configure(final HttpSecurity http) throws Exception {

	        http.authorizeRequests()
	             .antMatchers(HttpMethod.GET, "/user/**").hasRole("USER")  
	             .antMatchers(HttpMethod.POST, "/user/signup").permitAll().anyRequest().authenticated().and().csrf().disable();     
	    
	        

	    }
		
		
}