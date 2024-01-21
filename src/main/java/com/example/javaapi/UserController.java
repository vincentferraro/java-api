package com.example.javaapi;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.javaapi.UserRepository;


@RestController

public class UserController {

    private UserRepository userRepository;

    @GetMapping(path="/users")
    public @ResponseBody Iterable<User> getUsers() {
        
        return userRepository.findAll();
        // return ResponseEntity.ok(new User(1,"Vincent","abc123"));
    }

    // @GetMapping("/{userId}")
    // public ResponseEntity<User> getUserById(@PathVariable Number userId) {
    //     switch(userId.intValue()){
    //         case 1:
    //         return ResponseEntity.ok(new User(1,"Vincent","abc123"));
    //         case 2:
    //         return ResponseEntity.ok(new User(2,"Kad","def456"));
    //         default:
    //         return ResponseEntity.notFound().build();
            
    //     }
    // }
    
    // @PostMapping
    // public ResponseEntity<User> createUser(@RequestBody User user,UriComponentsBuilder ucb ) {
    //     User userSaved = new User(user.id(), user.name(), user.password());
    //     URI uri = ucb .path("cashcards/{id}")
    //             .buildAndExpand(userSaved.id())
    //             .toUri();
    //     System.out.println(userSaved.id() + " , "+ userSaved.name()+ " , "+userSaved.password());
    //     return ResponseEntity.created(uri).build();
    // }
    
    
    
}
