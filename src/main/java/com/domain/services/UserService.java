package com.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.models.entities.User;
import com.domain.models.repos.UserRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {
        
        @Autowired
        private UserRepo userRepo;

        public User save(User user){
                return userRepo.save(user);
        }

        public Iterable<User> findAll(User user){
                return userRepo.findAll();
        }

        public User findById(Long id){
                return userRepo.findById(id).get();
        }

        public void deleteById(Long id){
                userRepo.deleteById(id);
        }
}
