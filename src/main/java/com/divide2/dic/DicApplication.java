package com.divide2.dic;

import com.divide2.base.repository.BaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = BaseRepository.class)
public class DicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicApplication.class, args);
	}
}
