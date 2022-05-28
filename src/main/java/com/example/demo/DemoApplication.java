package com.example.demo;

import com.example.demo.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	PlayerRepository playerRepository;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
