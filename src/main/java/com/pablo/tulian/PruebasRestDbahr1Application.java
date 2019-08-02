package com.pablo.tulian;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class PruebasRestDbahr1Application extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(PruebasRestDbahr1Application.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(PruebasRestDbahr1Application.class, args);
	}

}
