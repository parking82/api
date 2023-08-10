package com.parking82.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking82.api.model.User;

public interface UserRespositorie extends JpaRepository<User, Long> {
}
