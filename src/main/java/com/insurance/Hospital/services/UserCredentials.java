package com.insurance.Hospital.services;

import javax.servlet.http.HttpSession;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.insurance.Hospital.daos.LoginDao;
import com.insurance.Hospital.models.LoginClass;


@Service
public class UserCredentials implements UserDetailsService {

	@Autowired
	private LoginDao daoLayer;
	@Autowired
	HttpSession session;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LoginClass lc = daoLayer.getUserByUsername(username);
		if (lc == null) {
			throw new UsernameNotFoundException("User not found");
		}
		session.setAttribute("login", lc.getRoleId());
		// Replace with actual roles from your database
		return User.builder().username(username).password(lc.getPassword()).build();
	}
}
