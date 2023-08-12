package com.parking82.api.entities;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateEntry;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate dateExit;
    private String hourEntry;
    private String hourExit;
    private String value;
    private String period;
    @ManyToOne
    @JoinColumn(name = "vagancy_id")
    private Vacancy vacancy;

}
