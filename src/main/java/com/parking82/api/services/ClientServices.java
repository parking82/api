package com.parking82.api.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.parking82.api.entities.Client;
import com.parking82.api.respository.ClientRepository;

@Service
public class ClientServices {

    private ClientRepository clientRepository;

    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> list() {
        return clientRepository.findAll();
    }

    
}
