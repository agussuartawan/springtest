package com.domain.controllers;

import org.hibernate.loader.entity.CacheEntityLoaderHelper.EntityStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.domain.dto.ResponseData;
import com.domain.models.entities.User;
import com.domain.services.UserService;
import jakarta.persistence.Entity;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {
        
        @Autowired
        private UserService userService;

        @PostMapping
        public ResponseEntity<ResponseData<User>> create(@Valid @RequestBody User user, Errors errors){

			ResponseData<User> responseData = new ResponseData<>();

			if (errors.hasErrors()) {
				for (ObjectError error : errors.getAllErrors()) {
					responseData.getMessages().add(error.getDefaultMessage());
				}
				responseData.setStatus(false);
				responseData.setPayload(null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
			}
			responseData.setStatus(true);
			responseData.setPayload(userService.save(user));
			return ResponseEntity.ok(responseData);
        }

        @GetMapping
        public Iterable<User> findAll(User user){
                return userService.findAll(user);
        }

        @GetMapping("/{id}")
        public User findOne(@PathVariable("id") Long id){
                return userService.findOne(id);
        }

        @PutMapping
        public ResponseEntity<ResponseData<User>> update(@Valid @RequestBody User user, Errors errors){
			ResponseData<User> responseData = new ResponseData<>();

			if(errors.hasErrors()){
				for (ObjectError error : errors.getAllErrors()) {
					responseData.getMessages().add(error.getDefaultMessage());
				}
				responseData.setStatus(false);
				responseData.setPayload(null);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
			}
			responseData.setStatus(true);
			responseData.setPayload(userService.save(user));
			return ResponseEntity.ok(responseData);
        }

        @DeleteMapping("/{id}")
        public void deleteOne(@PathVariable("id") Long id) {
                userService.deleteOne(id);
        }
}
