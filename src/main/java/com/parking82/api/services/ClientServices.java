package com.parking82.api.services;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.parking82.api.entities.Payment;
import com.parking82.api.entities.Vacancy;
import com.parking82.api.respository.PaymentRepository;
import com.parking82.api.respository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking82.api.entities.Client;
import com.parking82.api.respository.ClientRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientServices {

    private ClientRepository clientRepository;

    @Autowired
    private VacancyRepository vacancyRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public ClientServices(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client save(Client client) {

        client.getVacancy().setStatus("Ocupada");

        return clientRepository.save(client);
    }

    public List<Client> list() {
        return clientRepository.findAll();
    }

    public Client findByPlate(String plate) {
        return clientRepository.findByPlate(plate);
    }

    public Vacancy findById(Long id) {
        return vacancyRepository.findById(id).get();
    }

    public Client quit(Client client) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime entry = LocalTime.parse(client.getHourEntry().toString(), formatter);
        LocalTime exit = LocalTime.parse(client.getHourExit().toString(), formatter);

        Duration interval = Duration.between(entry, exit);

        LocalTime localTime = LocalTime.of((int) interval.toHours(), (int) interval.toMinutes() % 60);
        String period = localTime.format(formatter);
        client.setPeriod(period);

        double total = interval.toMinutes() % 60 * 0.0233333333333333;

        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        String totalFormatter = decimalFormat.format(total);

        if (interval.toMinutes() % 60 <= 300) {
            client.getPayment().setPayment(7.0);
        } else {
            client.getPayment().setPayment(Double.parseDouble(totalFormatter));
        }

        paymentRepository.save(client.getPayment());

        return client;
    }

    public Client receipt(Client client) {

        var vacancy = findById(client.getId());
        clientRepository.deleteById(client.getId());
        vacancyRepository.deleteById(client.getId());

        return client;
    }

}
