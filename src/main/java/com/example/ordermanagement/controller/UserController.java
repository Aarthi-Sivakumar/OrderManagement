package com.example.ordermanagement.controller;

import com.example.ordermanagement.api.UserApi;
import com.example.ordermanagement.model.User;
import com.example.ordermanagement.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController implements UserApi {

    UserService userService;

    public UserController(UserService userService){
        this.userService=userService;
    }

    @Override
    public ResponseEntity<Void> saveUserDetails(User user) {
        userService.saveUserDetails(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<User>> getUserDetails(String name) {
        return new ResponseEntity<>(userService.getUserDetails(name),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> deleteUserDetails(String name) {
        userService.deleteUserByUserName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
