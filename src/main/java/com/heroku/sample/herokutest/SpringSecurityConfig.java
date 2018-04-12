package com.heroku.sample.herokutest;

import java.nio.file.AccessDeniedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;

@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	public AccessDeniedHandler accessDeniedHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		 http
         .authorizeRequests()
             .antMatchers("/", "/home").permitAll()
//			 .antMatchers("/hello/**").hasAnyRole("ADMIN")
			 .antMatchers("/hello/**").hasAnyRole("USER")
             .anyRequest().authenticated()
             .and()
         .formLogin()
             .loginPage("/login")
             .permitAll()
             .and()
         .logout()
             .permitAll()
             .and()
             .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("sankar").password("sankar").roles("USER");

	}
}
