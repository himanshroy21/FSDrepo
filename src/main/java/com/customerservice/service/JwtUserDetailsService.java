package com.customerservice.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.customerservice.config.JwtTokenUtil;
import com.customerservice.dao.CustomerDAO;
import com.customerservice.entity.Customer;
import com.customerservice.entity.JwtRequest;
import com.customerservice.entity.JwtResponse;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDAO customerDAO;
	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	
//	@Autowired
//	private AuthenticationManager authenticationManager;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Customer c= customerDAO.findByCustEmail(username);
		if (c.getCustEmail().equals(username)) {
			return new User(c.getCustEmail(),c.getPassword(),getAuthority(c));
					
					
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	private Set getAuthority(Customer user) {
        Set authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "CUSTOMER"));
        return authorities;
  
	}
//	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
//        String userName = jwtRequest.getUsername();
//        String userPassword = jwtRequest.getPassword();
//        authenticate(userName, userPassword);
//
//        UserDetails userDetails = loadUserByUsername(userName);
//        String newGeneratedToken = jwtTokenUtil.generateToken(userDetails);
//
//        return new JwtResponse(newGeneratedToken);
//  }
//	private void authenticate(String userName, String userPassword) throws Exception {
//        try {
//               authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, userPassword));
//        } catch (DisabledException e) {
//               throw new Exception("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//               throw new Exception("INVALID_CREDENTIALS", e);
//        }
//  }


}
