package com.example.reg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.expression.spel.ast.Projection;



@SpringBootApplication
public class RegDemoApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Projection.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(RegDemoApplication.class, args);
	}

}
