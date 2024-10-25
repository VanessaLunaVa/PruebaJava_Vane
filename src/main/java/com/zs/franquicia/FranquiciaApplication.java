package com.zs.franquicia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.zs.franquicia")
public class FranquiciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FranquiciaApplication.class, args);
	}

}
