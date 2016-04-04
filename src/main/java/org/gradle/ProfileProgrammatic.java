package org.gradle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

public class ProfileProgrammatic implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileProgrammatic.class);

	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		LOGGER.info("Application running on dev profile");
		ConfigurableEnvironment environment = applicationContext.getEnvironment();
		environment.addActiveProfile("dev");
	}

}
