package com.parking82.api.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long vacancy;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate entry;
    @DateTimeFormat(pattern = "dd/MM/yyy")
    private LocalDate output;
    private Double value;
    private LocalDate period;

}
