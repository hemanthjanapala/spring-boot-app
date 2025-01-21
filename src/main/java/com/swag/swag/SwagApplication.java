package com.swag.swag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class SwagApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SwagApplication.class, args);
		int port = context.getEnvironment().getProperty("local.server.port", Integer.class, 8080);
		System.out.println("Server started on Tomcat on port " + port);
	}
}

