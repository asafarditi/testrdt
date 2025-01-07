package com.example.nexus_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
//When you run this main method, Spring Boot starts an embedded server (by default Tomcat) on http://localhost:8080.
@SpringBootApplication //Tells Spring Boot to auto-configure the application, scanning for components
@EnableScheduling //Enables scheduling support so we can run methods on a timer (e.g., to update and broadcast platform statuses every second).
public class NexusCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(NexusCoreApplication.class, args);
	}

}
