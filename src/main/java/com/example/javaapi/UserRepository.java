package com.example.javaapi;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.relational.core.mapping.Table;
import java.util.Optional;

@Table("users")
public interface UserRepository extends CrudRepository<User, Integer> {
    
    Optional<User> findById(Integer id);
}