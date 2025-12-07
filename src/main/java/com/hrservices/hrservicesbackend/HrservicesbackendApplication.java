package com.hrservices.hrservicesbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.hrservices.hrservicesbackend.Entity")
@EnableJpaRepositories("com.hrservices.hrservicesbackend.Repositories")
public class HrservicesbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrservicesbackendApplication.class, args);
	}

}
