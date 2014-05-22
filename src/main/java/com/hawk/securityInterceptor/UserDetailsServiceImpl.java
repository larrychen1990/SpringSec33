package com.hawk.securityInterceptor;


import java.util.HashSet;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * get user's  info,get the user's info by username
 * !!!pls be notoced that there is no autacation user info,we just write it in applicationContext.xml
 * 
 * @author lyletzzzw
 */
@Transactional(readOnly = true)
public class UserDetailsServiceImpl implements UserDetailsService {
 
	/**
	 * 
	 * callback function to get user's Details
	 * 
	 * @author lyletzzzw
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {

		Set<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>();
		grantedAuths.add(new GrantedAuthorityImpl("ROLE_USER"));


		//-- no props in mini -web,we just set them to true
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		String userId= "userID";
		String userName = "user";
		String authenticator="user";

		UserDetails userdetails = new SecurityUser(userId, userName,  authenticator, enabled,
				accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

		return userdetails;
	}
}