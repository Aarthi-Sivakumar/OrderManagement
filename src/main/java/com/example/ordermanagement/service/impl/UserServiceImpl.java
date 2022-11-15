package com.example.ordermanagement.service.impl;

import com.example.ordermanagement.exception.ResourceAlreadyExists;
import com.example.ordermanagement.exception.ResourceNotFound;
import com.example.ordermanagement.model.User;
import com.example.ordermanagement.repository.UserRepository;
import com.example.ordermanagement.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public static final String E403= "already exists";
    public static final String E404= "not found";

    @Override
    public void saveUserDetails(User user) {
        Optional<User> mailExists = userRepository.findByMail(user.getMail());
        if(mailExists.isPresent()){
            throw new ResourceAlreadyExists(E403);
        }
        userRepository.save(user);
    }

    @Override
    public List<User> getUserDetails(String name) {
        Optional<User> userExists = userRepository.findByUserName(name);
        if(!userExists.isPresent()){
            throw new ResourceNotFound(E404);
        }
        return List.of(userExists.get());
    }

    @Override
    public void deleteUserByUserName(String name) {
        Optional<User> userExists = userRepository.findByUserName(name);
        if(!userExists.isPresent()){
            throw new ResourceNotFound(E404);
        }
        userRepository.deleteById(userExists.get().getUserId());
    }
}
