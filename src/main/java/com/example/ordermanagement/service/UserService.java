package com.example.ordermanagement.service;

import com.example.ordermanagement.model.User;

import java.util.List;

public interface UserService {

    public void saveUserDetails(User user);

    public List<User> getUserDetails(String name);

    void deleteUserByUserName(String name);
}

