package com.example.springbootwithreactjs;

import com.example.springbootwithreactjs.controller.MyRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SpringBootWithReactJsApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithReactJsApplication.class, args);
		try {
			getConnection();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static Connection getConnection() throws URISyntaxException, SQLException {
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
		System.out.println("-------------------------->");
		System.out.println("The JDBC_DATABASE_URL is: "+dbUrl);
		System.out.println("<--------------------------");
		return DriverManager.getConnection(dbUrl);
	}
}
