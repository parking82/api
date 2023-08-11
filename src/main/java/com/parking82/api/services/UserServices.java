package com.parking82.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parking82.api.entities.User;
import com.parking82.api.respository.UserRespository;

@Service
public class UserServices {

    private UserRespository userRespository;

    public UserServices(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    public User save(User user) {
        return userRespository.save(user);
    }

    public List<User> list() {
        return userRespository.findAll();
    }
    
}
