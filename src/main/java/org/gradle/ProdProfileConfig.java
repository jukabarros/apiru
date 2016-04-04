package org.gradle;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdProfileConfig {

	@Bean
	public Estudante estudante() {
		return new Estudante(2, "Black Widow", "novas tecnologias nti");
	}
}
