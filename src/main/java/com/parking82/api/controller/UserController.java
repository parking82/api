package com.parking82.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.parking82.api.entities.User;
import com.parking82.api.services.UserServices;

@RestController
@RequestMapping("/usuario")
public class UserController {

    private UserServices userServices;

    @Autowired
    private PasswordEncoder encoder;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok().body(userServices.list());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<User> save(@RequestBody User user) {

        user.setPassword(encoder.encode(user.getPassword()));
        user.setConfirmPassword(encoder.encode(user.getConfirmPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.save(user));

    }

}