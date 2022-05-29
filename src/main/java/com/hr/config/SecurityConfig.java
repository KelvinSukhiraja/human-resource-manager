package com.hr.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource datasource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(datasource).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/userlogin", "/signup", "/process-signup").permitAll()
		.antMatchers("/addAdmin", "/addEmployee", "/addJob", "/addDept", "/showUser").hasAuthority("ADMIN")
		.antMatchers("/*").authenticated()
//		.antMatchers("/usertest").hasAuthority("user")
		.and()
			.formLogin().loginPage("/userlogin")
			.and()
			.httpBasic()
			.and().logout();
	}
}
