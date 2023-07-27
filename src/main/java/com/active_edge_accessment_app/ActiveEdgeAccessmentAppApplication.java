package com.active_edge_accessment_app;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActiveEdgeAccessmentAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActiveEdgeAccessmentAppApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
