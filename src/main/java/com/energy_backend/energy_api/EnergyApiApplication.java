package com.energy_backend.energy_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EnergyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EnergyApiApplication.class, args);
	}

	@Component
	public class WebConfig implements WebMvcConfigurer {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("http://127.0.0.1:5173/")
					.allowedMethods("GET","POST", "PUT", "DELETE", "OPTIONS", "HEAD");
		}

	}
}
