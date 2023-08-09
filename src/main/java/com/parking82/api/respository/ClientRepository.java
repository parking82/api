package com.parking82.api.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking82.api.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
}
