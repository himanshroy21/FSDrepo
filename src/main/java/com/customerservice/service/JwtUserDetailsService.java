package com.customerservice.service;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.customerservice.dao.CustomerDAO;
import com.customerservice.entity.Customer;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private CustomerDAO customerDAO;
	
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
}
