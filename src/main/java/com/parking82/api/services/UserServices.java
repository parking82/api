package com.parking82.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parking82.api.model.User;
import com.parking82.api.respository.UserRespositorie;

@Service
public class UserServices {

    private UserRespositorie userRespositorie;

    public UserServices(UserRespositorie userRespositorie) {
        this.userRespositorie = userRespositorie;
    }

    public User save(User user) {
        return userRespositorie.save(user);
    }

    public List<User> list() {
        return userRespositorie.findAll();
    }
    
}
