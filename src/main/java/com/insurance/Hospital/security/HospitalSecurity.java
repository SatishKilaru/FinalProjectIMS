package com.insurance.Hospital.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.insurance.Hospital.services.UserCredentials;


@Configuration
@EnableWebSecurity
public class HospitalSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserCredentials customUserDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/", "/login").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login") // Custom login page URL
				.defaultSuccessUrl("/index") // Redirect after successful login
				.permitAll().and().logout().logoutSuccessUrl("/login").permitAll();
	}

	// @Bean
	// public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	// http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	// return http.build();
	// }

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		// Use a secure password encoder like BCrypt in production
		return NoOpPasswordEncoder.getInstance();
	}
}
