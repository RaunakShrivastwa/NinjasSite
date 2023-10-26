package com.Teaching;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeachingSiteApplication {
	public static void main(String[] args) {
		SpringApplication.run(TeachingSiteApplication.class, args);
		System.out.println("project is running...");
		System.out.println("http://localhost:9096/home");
	}

}


