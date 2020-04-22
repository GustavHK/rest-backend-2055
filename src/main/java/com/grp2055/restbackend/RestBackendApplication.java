package com.grp2055.restbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


// Build jar: mvnw clean package
// Run jar: mvnw spring-boot:run
@SpringBootApplication
public class RestBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestBackendApplication.class, args);
    }



}
