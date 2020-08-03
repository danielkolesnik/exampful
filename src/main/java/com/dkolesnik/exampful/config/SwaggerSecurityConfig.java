package com.dkolesnik.exampful.config;

import springfox.documentation.swagger.web.ApiKeyVehicle;
import springfox.documentation.swagger.web.SecurityConfiguration;

public class SwaggerSecurityConfig extends SecurityConfiguration {

	/**
	 * Default security configuration constructor.
	 *
	 * @param    headerName security key header name
	 */
	SwaggerSecurityConfig(String headerName) {
		super("", "", "", "", "", ApiKeyVehicle.HEADER, headerName, ",");
	}
}
