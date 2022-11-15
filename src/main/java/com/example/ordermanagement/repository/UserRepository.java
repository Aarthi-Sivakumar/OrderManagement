package com.example.ordermanagement.repository;

import com.example.ordermanagement.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User> findByMail(String mail);

    Optional<User> findByUserName(String name);
}

