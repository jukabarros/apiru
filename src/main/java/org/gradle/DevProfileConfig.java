package org.gradle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevProfileConfig {
	@Bean
	public Estudante estudante() {
		return new Estudante(1, "Loki", "novas tecnologias nti");
	}
}
