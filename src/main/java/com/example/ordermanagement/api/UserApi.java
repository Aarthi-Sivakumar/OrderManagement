package com.example.ordermanagement.api;

import com.example.ordermanagement.model.User;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/user")
public interface UserApi {

    @PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE }, consumes = {
            MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Void> saveUserDetails(@Valid @RequestBody User user);

    @GetMapping(value = "/{name}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<User>> getUserDetails(@PathVariable String name);

    @DeleteMapping(value = "/{name}")
    public ResponseEntity<Void> deleteUserDetails(@PathVariable String name);
}

