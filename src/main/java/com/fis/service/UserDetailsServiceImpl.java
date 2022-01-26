package com.fis.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.fis.model.Role;
import com.fis.model.UserInfo;
import com.fis.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user=userRepo.findByUsername(username).get();
		return new User(user.getUsername(),user.getPassword(),getAuthorities(user.getRoles()));
	}

	private List<SimpleGrantedAuthority> getAuthorities(List<Role> roles) {
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		for (Role role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		return authorities;
	}
	
	public UserInfo createUser(UserInfo user)
	{
		return userRepo.save(user);
	}

	
	
}
