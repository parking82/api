package com.parking82.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking82.api.entities.User;

import java.util.Optional;

public interface UserRespository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}
