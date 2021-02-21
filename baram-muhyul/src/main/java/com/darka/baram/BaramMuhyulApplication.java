package com.darka.baram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration//(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories(basePackages = "com.darka.baram.repository")
public class BaramMuhyulApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaramMuhyulApplication.class, args);
	}

}
