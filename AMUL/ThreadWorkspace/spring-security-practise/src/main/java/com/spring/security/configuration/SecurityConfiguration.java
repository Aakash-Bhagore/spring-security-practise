package com.spring.security.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired private DataSource dataSource;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
      
	/**
	 * It's a Authorization process
	 * 
	 * */
	
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeHttpRequests() 
//		    .antMatchers("/balance").authenticated()
//		    .antMatchers("/statement").authenticated()
//		    .antMatchers("/myloan").authenticated()
//		    .antMatchers("/home").permitAll()
//		    .antMatchers("/contact").permitAll()
//		    .antMatchers("/save").permitAll()
//		    .and().formLogin()
//		    .and().httpBasic();
//	}
	
	/**
	 * It's a Authentication process
	 * 
	 * */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//	    .withUser("ronaldo").password("ronaldo").authorities("admin").and()
//	    .withUser("messi").password("messi").authorities("user").and()
//	    .withUser("pele").password("pele").authorities("client").and()
//	    .passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
	
	/**
	 * It's a Authentication process
	 * 
	 * */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.jdbcAuthentication()
//		    .dataSource(dataSource)
//		    .usersByUsernameQuery("select user_name,user_psw,user_enabled from user_dtls where user_name=?")//finding the user by thier username
//		    .authoritiesByUsernameQuery("select user_name,user_psw from user_dtls where user_name=?")//finding the user authority by using thier username
//		    .passwordEncoder(encoder);
//	}
	
	/**
	 * It's a Authorization process
	 * 
	 * */
	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
		    .antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
	}
}
