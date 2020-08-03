package com.dkolesnik.exampful.config;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
@PropertySource(name = "swagger", value = "classpath:swagger.properties")
@Profile({"documentation", "swagger"})
public class SwaggerConfig implements WebMvcConfigurer {

	private String clientId = "username";

	private String clientSecret = "password";

	@Autowired
	public SwaggerConfig() { }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html")
			.addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**")
			.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/**
	 * Creates swagger configuration.
	 *
	 * @return swagger configuration docket
	 */
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.dkolesnik.exampful.controller"))
			.paths(PathSelectors.any())
			.build()
			.pathMapping("/")
			.directModelSubstitute(DateTime.class, String.class)
			.directModelSubstitute(Enum.class, String.class)
			.apiInfo(
				new ApiInfoBuilder()
					.title("dKolesnik, REST API")
					.description("Core API documentation")
					.version("0.1.1")
					.contact(new Contact("Daniel A. Kolesnik", "https://github.com/danielkolesnik", "daneelkolesnik@gmail.com"))
					.build()
			);
	}

	@Bean
	public SwaggerMapperConfig swaggerMapper() {
		return new SwaggerMapperConfig();
	}

//	@Bean
//	public SecurityConfiguration securityConfiguration() {
//		return new SwaggerSecurityConfig(HttpHeaders.AUTHORIZATION);
//	}

}
