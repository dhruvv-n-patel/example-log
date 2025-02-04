package com.obsTask.example;

import org.springframework.boot.SpringApplication;
import java.util.logging.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


@EnableScheduling
@ComponentScan(basePackages = {"com.obsTask.Logging","com.obsTask.controller"})
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleApplication.class, args);
		Logger logger 
        = Logger.getLogger( 
            ExampleApplication.class.getName()); 
        
        
	}

}
