package com.dkolesnik.exampful.config;

import com.dkolesnik.exampful.rest.ApplicationProperties;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NamingConventions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.concurrent.Executors;

/**
 * Base Spring Application Configuration
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@Configuration
@ComponentScan(basePackages = "com.dkolesnik")
@EnableAutoConfiguration
@EnableAsync
public class CoreApplicationConfig {

	private final ApplicationContext applicationContext;

	public CoreApplicationConfig (@Autowired ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	/**
	 * Create base Dispatcher Servlet
	 *
	 * @return DispatcherServlet
	 */
	@Bean
	public DispatcherServlet dispatcherServlet() {
		return new DispatcherServlet();
	}

	/**
	 * Create Application Properties Bean
	 *
	 * @return
	 */
	@Bean
	public ApplicationProperties applicationProperties() {
		return new ApplicationProperties();
	}

	/**
	 * Config for rest template
	 *
	 * @param builder
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	/**
	 * Initialize Model Mapper
	 *
	 * @return
	 */
	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		modelMapper.getConfiguration()
			.setFieldMatchingEnabled(true)
			.setDeepCopyEnabled(false)
			.setAmbiguityIgnored(true)
			.setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
			.setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);

		return modelMapper;
	}

	/**
	 * Declare Task Executor for Async Operations
	 *
	 * @return
	 */
	@Bean
	public TaskExecutor taskExecutor () {
		return new ConcurrentTaskExecutor(Executors.newFixedThreadPool(3));
	}

//	@Bean
//	public ClientMessage clientMessage() {
//		ClientMessage result = new ClientMessageDataBaseImpl();
//
//		return result;
//	}

}
