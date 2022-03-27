/**
 * 
 */
package com.app.forumWebApp.config;






import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.app.forumWebApp.service.UserRepositoryUserDetailsService;

/**
 * @author Shubhashish PC
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
		
	@Autowired
	DataSource datasource;
	
	@Autowired
	private UserRepositoryUserDetailsService userDetailsService;
	
	

	    //Public API for user registration

	    
	    @Autowired
	    private AuthEntryPointJwt unauthorizedHandler;
	    @Bean
	    public AuthTokenFilter authenticationJwtTokenFilter() {
	      return new AuthTokenFilter();
	    }
	    @Override
	    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
	      authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	    }
	    @Bean
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	      return super.authenticationManagerBean();
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder() {
	      return new BCryptPasswordEncoder();
	    }
	    
	    @Override
	    protected void configure(final HttpSecurity http) throws Exception {

	        http
	        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
	             .antMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ROLE_USER")
	             .antMatchers(HttpMethod.GET, "/board/**").hasAnyAuthority("ROLE_USER")
	             .antMatchers(HttpMethod.GET, "/posts/**").hasAnyAuthority("ROLE_USER")
	             .antMatchers(HttpMethod.POST, "/user/signin").permitAll()
	             .antMatchers(HttpMethod.GET, "/home").permitAll()
	             .antMatchers(HttpMethod.POST, "/user/signup").permitAll().anyRequest().authenticated().and().csrf().disable();  
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	    
	        

	    }
	    
	    /*protected void configure(HttpSecurity http) throws Exception {
	        http.cors().and().csrf().disable()
	          .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
	          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	          .authorizeRequests().antMatchers("/user/**").hasRole("USER")
	          .antMatchers(HttpMethod.POST, "/user/signup").permitAll()
	          .anyRequest().authenticated();
	        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	      }
	      
	      */
	  
	   /* protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    	
	   auth.jdbcAuthentication()
	    .dataSource(datasource)
	    .usersByUsernameQuery(
	    "SELECT username, password, 'true' as enabled FROM member WHERE username = ?")
	    .authoritiesByUsernameQuery(
	    "SELECT member.username, member_role.role as authorities " +
	    "FROM member, member_role " +
	    "WHERE member.username = ? AND member.id = member_role.member_id");
	    }
	    	
	    	auth
	    	.userDetailsService(userDetailsService);
}*/
}