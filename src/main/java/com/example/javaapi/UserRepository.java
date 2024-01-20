package com.example.javaapi;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User,Number> {
    
}
