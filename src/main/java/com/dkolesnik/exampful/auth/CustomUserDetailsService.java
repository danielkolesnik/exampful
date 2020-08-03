package com.dkolesnik.exampful.auth;

import com.dkolesnik.exampful.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Customized implementation of User Details Service for Spring Security
 *
 * @author	Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version	0.1.1
 * @since	2020-07-02
 */
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	public CustomUserDetailsService() {
		log.info("#### CustomUserDetailsService. Initialized.");
	}

	/**
	 * Load User Details by its Primary username
	 *
	 * @param userName
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		// User result = new User(userName, "password", Collections.EMPTY_LIST);

		// We must recreate User Properly. Like it is done in Spring.
		CustomJDBCUserDetailsManager userDetailsManager = BeanUtil.getBean("customJdbcUserDetailsManager", CustomJDBCUserDetailsManager.class);
		UserDetails userDetails = userDetailsManager.loadUserByUsername(userName);

		return userDetails;
	}
}
