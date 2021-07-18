package com.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(users.username("john").password("john@987").roles("EMPLOYEE"))
		.withUser(users.username("mary").password("mary@987").roles("EMPLOYEE", "MANAGER"))
		.withUser(users.username("susan").password("susan@987").roles("EMPLOYEE", "ADMIN"));
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/login").permitAll()
		.antMatchers("/","/list-todos","/add-todo").hasRole("EMPLOYEE")
		.antMatchers("/delete-todo/**").hasRole("ADMIN")
		.antMatchers("/*todo").hasRole("MANAGER")
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/user")
			.permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}
	
}
