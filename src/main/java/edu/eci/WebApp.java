package edu.eci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan()
public class WebApp {
    public static void main(String[] args) {
        SpringApplication.run(WebApp.class, args);
    }   
}
