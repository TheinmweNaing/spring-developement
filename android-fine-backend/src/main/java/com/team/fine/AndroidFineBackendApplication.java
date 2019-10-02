package com.team.fine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.team.fine.repo.CustomRepoImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepoImpl.class)
public class AndroidFineBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AndroidFineBackendApplication.class, args);
	}

}
