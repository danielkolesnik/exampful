package com.dkolesnik.exampful.rest;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

/**
 * Simple implementation of the Application properties helper. Used in API calls, etc.
 *
 * @author   Daniel A. Kolesnik <ekalosha@dfusiontech.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@Getter
public class ApplicationProperties {

	@Value("${build.version}")
	private String buildVersion;

	@Value("${build.artifactId}")
	private String buildArtifact;

	@Value("${exampful.ui.url}")
	private String uiUrl;

	@Value("${exampful.admin-ui.url}")
	private String adminUiUrl;

	@Value("${exampful.api.url}")
	private String apiUrl;

	@Autowired
	private Environment environment;

	public boolean isEmailNotificationsEnabled() {
		boolean result = false;

		if ("true".equalsIgnoreCase(environment.getProperty("exampful.notifications.email.enabled"))) {
			result = true;
		}

		return result;
	}

	public String getEmailMessageFromAddress() {
		String result = "Do Not Reply <noreply@cyberinnovativetech.com>";

		if (environment.containsProperty("exampful.notifications.email.from")) {
			result = environment.getProperty("exampful.notifications.email.from");
		}

		return result;
	}

}

