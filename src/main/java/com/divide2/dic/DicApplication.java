package com.divide2.dic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.divide2.dic.repository")
public class DicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicApplication.class, args);
	}
}
