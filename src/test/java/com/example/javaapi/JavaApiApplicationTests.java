package com.example.javaapi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;

import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.web.client.TestRestTemplate;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class JavaApiApplicationTests {

	@Autowired
	TestRestTemplate restTemplate;

	@Test
	void shouldReturnUsers(){
		ResponseEntity<String>  response = restTemplate.getForEntity("/users", String.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		
		DocumentContext document = JsonPath.parse(response.getBody());
		Number id = document.read("$.id");
		String name = document.read("$.name");
		String pass = document.read("$.password");

		assertThat(id).isEqualTo(1);
		assertThat(name).isEqualTo("Vincent");
		assertThat(pass).isEqualTo("abc123");

	}

	@Test 
	void shouldReturnAnUser(){
		ResponseEntity<String> response = restTemplate.getForEntity("/users/2", String.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext document = JsonPath.parse(response.getBody());
		Number id = document.read("$.id");
		String name = document.read("$.name");
		String pass = document.read("$.password");

		assertThat(id).isEqualTo(2);
		assertThat(name).isEqualTo("Kad");
		assertThat(pass).isEqualTo("def456");

	}

	@Test
	void shouldCreateANewUser(){
		User userCreated = new User(3,"Nah","ghi789");
		ResponseEntity<Void> response = restTemplate.postForEntity("/users", userCreated, Void.class);

		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);


	}

}
