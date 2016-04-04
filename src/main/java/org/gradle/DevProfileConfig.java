package org.gradle;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfileConfig {

	public Estudante infoEstudante() {
		return new Estudante("novas tecnologia", 2016);		
	}
}
