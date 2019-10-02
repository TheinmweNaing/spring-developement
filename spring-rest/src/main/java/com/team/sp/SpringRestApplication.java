package com.team.sp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.team.sp.repo.CustomRepoImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomRepoImpl.class)
public class SpringRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApplication.class, args);
	}

}
