package com.parking82.api.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String vehicle;
    private String plate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private String hourEntry;
    private String hourExit;
    private String period;
    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
    @ManyToOne
    @JoinColumn(name = "vagancy_id")
    private Vacancy vacancy;

}
