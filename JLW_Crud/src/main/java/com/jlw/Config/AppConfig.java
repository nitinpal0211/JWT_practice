package com.jlw.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.http.HttpMethod;

@Configuration
public class AppConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain springSecurityConfig(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests()
		.antMatchers(HttpMethod.POST,"/employee").permitAll()
		.anyRequest()
		.authenticated().and().csrf().disable().formLogin().and().httpBasic();
		
//		http.authorizeHttpRequests().requestMatchers(HttpMethod.POST,)
//		
		return http.build();
	}
	
}
