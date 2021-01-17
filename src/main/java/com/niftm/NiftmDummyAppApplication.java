package com.niftm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class NiftmDummyAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(NiftmDummyAppApplication.class, args);
	
		//context.close();
	}

}
