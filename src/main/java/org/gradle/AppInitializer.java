package org.gradle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.getEnvironment().setActiveProfiles("prod");
		context.scan("org.gradle");
		context.refresh();
		Estudante estudante = context.getBean(Estudante.class);
		System.out.println(estudante.toString());
	}
}
