package com.parking82.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.parking82.api.model.User;
import com.parking82.api.services.UserServices;

@RestController
@RequestMapping("/usuario")
public class UserController {

    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok().body(userServices.list());
    }

    @PostMapping("/cadastro")
    public ResponseEntity<User> save(@RequestBody User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userServices.save(user));
    }
    
}
