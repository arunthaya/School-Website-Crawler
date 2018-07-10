package com.example.springbootwithreactjs.controller;

import com.example.springbootwithreactjs.SpringBootWithReactJsApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyConfiguration {


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                System.out.println("-------------------------------------------->");
                System.out.println("inside corsMapping adding cors path: "+SpringBootWithReactJsApplication.CROSS_ORIGINS_PATH);
                System.out.println("-------------------------------------------->");
                registry.addMapping("/**");
            }
        };
    }
}

