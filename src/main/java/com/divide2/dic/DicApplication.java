package com.divide2.dic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchDataAutoConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication(exclude = ElasticsearchDataAutoConfiguration.class)
@EnableElasticsearchRepositories(basePackages = "com.divide2.dic.es.repo")
public class DicApplication {

	public static void main(String[] args) {
		SpringApplication.run(DicApplication.class, args);
	}
}
