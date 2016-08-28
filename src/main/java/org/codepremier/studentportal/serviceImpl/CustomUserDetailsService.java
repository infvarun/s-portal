package org.codepremier.studentportal.serviceImpl;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codepremier.studentportal.model.User;
import org.codepremier.studentportal.model.UserProfile;
import org.codepremier.studentportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService  {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UserService userService;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> userOptional = userService.findByUserName(userName);
		if(userOptional.isPresent()) {
			User user = userOptional.get();
			return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getStatus().equalsIgnoreCase("Active"), true, true, true, getGrantedAuthorities(user));
		}
		logger.info("Username is NOT found");
		throw new UsernameNotFoundException("UserName not found");
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserProfile userProfile : user.getUserProfiles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
		}
		return authorities;
	}
}
