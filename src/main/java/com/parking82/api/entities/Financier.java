package com.parking82.api.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Financier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private Double earningDay;
    private Double earningWeekly;
    private Double earningMonthly;
    private Double earningTotal;
    @OneToMany(mappedBy = "financier")
    private List<Payment> payment = new ArrayList<>();

}
