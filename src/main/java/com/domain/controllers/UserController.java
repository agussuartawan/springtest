package com.domain.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.models.entities.User;
import com.domain.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
        
        @Autowired
        private UserService userService;

        @PostMapping
        public User create(@RequestBody User user){
                return userService.save(user);
        }

        @GetMapping
        public Iterable<User> findAll(User user){
                return userService.findAll(user);
        }

        // @GetMapping
        // public User findById(Long id){
        //         return userService.findById(id).get();
        // }
}
