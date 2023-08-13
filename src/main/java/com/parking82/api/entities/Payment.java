package com.parking82.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String date;
    private String formPayment;
    private Double payment;
    @ManyToOne
    @JoinColumn(name = "financier_id")
    private Financier financier;

}
