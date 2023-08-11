package com.parking82.api.services;

import com.parking82.api.entities.User;
import com.parking82.api.respository.UserRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRespository userRespository;

    public UserDetailService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> user = userRespository.findByEmail(email);

        if (user.isPresent()) {
            return user.get();
        }

        throw new UsernameNotFoundException("No user found for " + email + ".");
    }
}
