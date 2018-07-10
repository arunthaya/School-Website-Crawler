package com.example.springbootwithreactjs;

import com.example.springbootwithreactjs.controller.MyRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWithReactJsApplication {

	public static String CROSS_ORIGINS_PATH;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithReactJsApplication.class, args);
		CROSS_ORIGINS_PATH = System.getenv().get("CROSS_ORIGINS_PATH");
	}
}
