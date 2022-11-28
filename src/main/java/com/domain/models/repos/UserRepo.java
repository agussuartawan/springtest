package com.domain.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.domain.models.entities.User;

public interface UserRepo extends CrudRepository<User, Long>{
        
}
