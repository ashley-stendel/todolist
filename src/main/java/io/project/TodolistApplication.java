package io.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		System.out.println("test");
		SpringApplication.run(TodolistApplication.class, args);
	}
}
