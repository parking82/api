package com.parking82.api.controller;

import java.time.LocalDate;
import java.util.List;

import com.parking82.api.respository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking82.api.entities.Client;
import com.parking82.api.services.ClientServices;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    
    private ClientServices clientServices;

    @Autowired
    private VacancyRepository vacancyRepository;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping
    public ResponseEntity<List<Client>> list() {
        return ResponseEntity.ok().body(clientServices.list());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Client> save(@RequestBody Client client) {
        vacancyRepository.save(client.getVacancy());
        client.setEntry(LocalDate.now());
        return ResponseEntity.status(HttpStatus.CREATED).body(clientServices.save(client));
    }

}
