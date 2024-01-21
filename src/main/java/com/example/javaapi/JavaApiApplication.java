package com.example.javaapi;

import java.util.NoSuchElementException;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaApiApplication.class, args);
	}

	// @Bean
	// CommandLineRunner runner(UserRepository repository){
	// 	return args ->{
	// 		User user = new User();
	// 		user.setId(1);
	// 		user.setName("Vincent");
	// 		user.setPassword("abc123");

	// 		repository.save(user);
	// 		User saved = repository.findById(user.getId().intValue()).orElseThrow(NoSuchElementException::new);
	// 	};
	// }

	@Bean
  CommandLineRunner runner(UserRepository repository) {
    return args -> {

      	User user = new User();
     	user.setId(2);
		user.setName("Kad");
		user.setPassword("abc123");

      repository.save(user);
      User saved = repository.findById(user.getId().intValue()).orElseThrow(NoSuchElementException::new);
    };
  }
}
