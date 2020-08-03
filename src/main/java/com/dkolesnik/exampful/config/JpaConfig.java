package com.dkolesnik.exampful.config;

import com.dkolesnik.exampful.repository.jpa.core.CoreRepositoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * Data Source and Transaction configuration.
 *
 * @author   Daniel A. Kolesnik <daneelkolesnik@gmail.com>
 * @version  0.1.1
 * @since    2020-07-02
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.dkolesnik.exampful.repository"}, repositoryBaseClass = CoreRepositoryImpl.class)
@EnableJpaAuditing
@Slf4j
public class JpaConfig implements TransactionManagementConfigurer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JpaConfig.class);

	/**
	 * Create default Transaction manager
	 *
	 * @return Default JpaTransactionalManager
	 */
	@Primary
	@Bean(name = "transactionManager")
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		return new JpaTransactionManager();
	}

}
