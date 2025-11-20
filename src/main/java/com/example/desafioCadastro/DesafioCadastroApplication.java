package com.example.desafioCadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DesafioCadastroApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioCadastroApplication.class, args);
	}

}
