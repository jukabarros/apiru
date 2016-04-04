package org.gradle;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class WebApplicationExample {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(WebApplicationExample.class).initializers(new ProfileProgrammatic()).run(args);
	}

}
