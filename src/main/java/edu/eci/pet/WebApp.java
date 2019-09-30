package edu.eci.pet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "edu.eci.pet" })
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }   
}
