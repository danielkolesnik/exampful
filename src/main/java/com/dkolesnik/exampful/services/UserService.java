package com.dkolesnik.exampful.services;

import com.dkolesnik.exampful.auth.UserDetailsImpl;
import com.dkolesnik.exampful.model.dto.DTOBase;
import com.dkolesnik.exampful.model.dto.user.UserListDTO;
import com.dkolesnik.exampful.model.jpa.entity.Users;
import com.dkolesnik.exampful.repository.jpa.UserRepository;
import com.dkolesnik.exampful.rest.exception.NotAuthenticatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User management Service. Implements basic user CRUD
 *
 * @author	Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version	0.1.1
 * @since	2020-07-02
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PermissionService permissionService;

	/**
	 * Get Users List
	 *
	 * @return Users List
	 */
	public List<UserListDTO> getList() {
		List<Users> items;

//		if (getCurrentUser().getOrganizationId() != null) {
//			items = userRepository.getListByOrganization(getCurrentUser().getOrganizationId());
//		} else {
			items = userRepository.findAll();
//		}

		List<UserListDTO> usersDTOList = DTOBase.fromEntitiesList(items, UserListDTO.class);

		return usersDTOList;
	}

	/**
	 * Get self User details
	 *
	 * @return User Details
	 */
//	public UserEditDTO getSelf() {
//
//		UserDetailsImpl user = getCurrentUser();
//		Users itemDetails = getOrganizationUser(user.getUserId());
//		UserEditDTO itemDTO = new UserEditDTO(itemDetails);
//
//		// Set User Permissions
//		Set<String> permissions = permissionService.getUserPermissionNames(user.getUserId());
//		itemDTO.setPermissions(permissions);
//
//		return itemDTO;
//	}

	/**
	 * Get Current Security User
	 *
	 * @return
	 */
	public UserDetailsImpl getCurrentUser() {
		Object securityUser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserDetailsImpl user = null;

		// Initialize current User Details
		if (securityUser != null && securityUser instanceof UserDetailsImpl) {
			user = (UserDetailsImpl) securityUser;
		}

		if (user == null) {
			throw new NotAuthenticatedException("User is not Authorized on this server.");
		}

		return user;
	}

}
