package com.parking82.api.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate entry;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate output;
    private Double value;
    private LocalDate period;
    @ManyToOne
    @JoinColumn(name = "vagancy_id")
    private Vacancy vacancy;

}
