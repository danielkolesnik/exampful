package com.dkolesnik.exampful.config;

import com.dkolesnik.exampful.rest.exception.APIErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring Application Configuration. Override some BEANs
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@Configuration
public class WebApplicationConfig {

	/**
	 * Overriding Error Attributes
	 *
	 * @return APIErrorAttributes
	 */
	@Bean
	public ErrorAttributes errorAttributes() {
		APIErrorAttributes result = new APIErrorAttributes();

		return result;
	}
}
