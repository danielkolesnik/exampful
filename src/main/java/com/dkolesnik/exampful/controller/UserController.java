package com.dkolesnik.exampful.controller;

import com.dkolesnik.exampful.model.dto.user.UserListDTO;
import com.dkolesnik.exampful.services.UserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * User management controller. Basic user CRUD.
 *
 * @author   Eugene A. Kalosha <ekalosha@dfusiontech.com>
 * @version  0.1.1
 * @since    2018-10-27
 */
@RestController
@RequestMapping(
	value = UserController.CONTROLLER_URI,
	produces = MediaType.APPLICATION_JSON,
	name = "Users Management Controller"
)
@Api(tags = {"User Management", "Administration"})
public class UserController {

	static final String CONTROLLER_URI = "/api/info/users";

	@Autowired
	private UserService userService;

	/**
	 * Get Users List
	 *
	 * @return Users List
	 */
	@RequestMapping(method = RequestMethod.GET, value = "", name = "Get Users List")
//	@ApiImplicitParams({
//		@ApiImplicitParam(name = "authorization", value = "oAuth Access token for API calls", defaultValue = "Bearer DF0310", required = true, dataType = "string", paramType = "header")
//	})
//	@PreAuthorize("@apiSecurity.hasPermission(T(com.monarchhealth.api.config.APIAction).USER_READ)")
	public List<UserListDTO> getList() {

		List<UserListDTO> result = userService.getList();

		return result;
	}
}
