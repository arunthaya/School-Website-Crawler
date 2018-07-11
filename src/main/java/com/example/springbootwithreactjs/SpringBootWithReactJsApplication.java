package com.example.springbootwithreactjs;

import com.example.springbootwithreactjs.controller.MyRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SpringBootWithReactJsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithReactJsApplication.class, args);
	}

	//possibly take out
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(
						"https://clever-bartik-f51fc7.netlify.com/"
				);
			}
		};
	}

}
