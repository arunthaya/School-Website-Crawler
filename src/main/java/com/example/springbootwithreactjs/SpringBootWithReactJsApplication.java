package com.example.springbootwithreactjs;

import com.example.springbootwithreactjs.controller.MyRestController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@SpringBootApplication
public class SpringBootWithReactJsApplication {

	private static Connection c = null;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithReactJsApplication.class, args);
		Statement stmt = null;
		try {
			c = getConnection();
			stmt = c.createStatement();
			String sql = "CREATE TABLE SCHOOL " +
					"(ID INT PRIMARY KEY	NOT NULL," +
					" NAME			TEXT	NOT NULL, " +
					" AGE			INT 	NOT NULL, " +
					" ADDRESS		CHAR(50))";
			stmt.executeUpdate(sql);
			stmt.close();
			c.close();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	private static Connection getConnection() throws URISyntaxException, SQLException {
		URI dbUri = new URI(System.getenv("DATABASE_URL"));

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		return DriverManager.getConnection(dbUrl, username, password);
	}
}
