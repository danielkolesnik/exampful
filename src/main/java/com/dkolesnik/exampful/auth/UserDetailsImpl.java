package com.dkolesnik.exampful.auth;

import com.dkolesnik.exampful.model.jpa.entity.Users;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * Default Spring user abstraction
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2010-07-02
 */
public class UserDetailsImpl extends User {

	private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

	@Getter
	private Long userId;

	@Getter
	private Long organizationId;

	/**
	 * Fully parametrized constructor
	 *
	 * @param	userId
	 * @param	username
	 * @param	password
	 * @param	enabled
	 * @param	authorities
	 */
	public UserDetailsImpl(Long userId, String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, true, true, true, authorities);

		this.userId = userId;
	}

	public UserDetailsImpl(UserDetails userDetails, Collection<? extends GrantedAuthority> authorities, Long userId) {
		this(userId, userDetails.getUsername(), userDetails.getPassword(), userDetails.isEnabled(), authorities);

//		if (userDetails instanceof UserDetailsImpl) {
//			organizationId = ((UserDetailsImpl) userDetails).organizationId;
//		}
	}

	/**
	 * Default User Entity constructor
	 *
	 * @param user
	 */
	public UserDetailsImpl(Users user) {
		this(Long.valueOf(user.getId()), user.getEmail(), user.getPassword(), user.getEnabled(), AuthorityUtils.NO_AUTHORITIES);

//		if (user.getOrganization() != null) {
//			organizationId = user.getOrganization().getId();
//		}
	}

}
