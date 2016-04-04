package org.gradle;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class AppInitializer {

	public static void main(String[] args) {
		new SpringApplicationBuilder(AppInitializer.class).run(args);
		DevProfileConfig profile = new DevProfileConfig();
		System.out.println(profile.infoEstudante().toString());
	}
}
