package com.parking82.api.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.parking82.api.entities.Payment;
import com.parking82.api.respository.PaymentRepository;
import com.parking82.api.respository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.parking82.api.entities.Client;
import com.parking82.api.services.ClientServices;

@RestController
@RequestMapping("/clientes")
public class ClientController {
    
    private ClientServices clientServices;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public ClientController(ClientServices clientServices) {
        this.clientServices = clientServices;
    }

    @GetMapping
    public ResponseEntity<List<Client>> list() {
        return ResponseEntity.ok().body(clientServices.list());
    }

    @PostMapping("/registrar")
    public ResponseEntity<Client> save(@RequestBody Client client) {

        client.setDate(LocalDate.now());
        vacancyRepository.save(client.getVacancy());
        paymentRepository.save(client.getPayment());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        client.setHourEntry(LocalTime.now().format(formatter));

        return ResponseEntity.status(HttpStatus.CREATED).body(clientServices.save(client));

    }

    @DeleteMapping("/fechar/{plate}")
    public ResponseEntity<?> finallyPeriod(@PathVariable String plate) {

        Client client = clientServices.findByPlate(plate);

        if(client == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado. Por favor, verifique a placa informada");
        }

        clientServices.receipt(client);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "HH:mm");

        client.setHourExit(LocalTime.now().format(formatter));

        clientServices.quit(client);

        client.getPayment().setDate(LocalDate.now().format(formatterDate));
        paymentRepository.save(client.getPayment());

        return ResponseEntity.status(HttpStatus.OK).body("\t\t\t\t\t\t\t\t\t--------- RECIBO (PARKING 82) ---------\n\n" +
                "\t\t\t\t\t\t\t\t\t\t\t\tDATA: " + LocalDate.now().format(formatterDate) +
                "\n\n\t\t\t\t\tCLIENTE: " + client.getName() +
                "\t\t\t\t\t\tVEÍCULO: " + client.getVehicle() +
                "\n\t\t\t\t\tPLACA: " + client.getPlate() +
                "\t\t\t\t\t\t\t\t\tVAGA: " + client.getVacancy().getVacancy() +
                "\n\t\t\t\t\tENTRADA: " + client.getHourEntry() +
                "\t\t\t\t\t\t\t\t\tSAÍDA: " + client.getHourExit() +
                "\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t\tPERMANÊNCIA: " + client.getPeriod() +
                "\n\t\t\t\t\t\t\t\t\t\t\t\t Á PAGAR: R$ "+ client.getPayment().getPayment() +
                "\n\n\t\t\t\tCNPJ: 99.107.370/0001-90 - Contato (82) 98162-1126 - E-mail parking82@contato.com" +
                "\n\t\t\t\t\t\t\t\tPaking 82 - Soluções em estacionamentos ©");
    }

}
