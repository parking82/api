package com.parking82.api.services;

import com.parking82.api.entities.Financier;
import com.parking82.api.respository.FinancierRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FinancierServices {

    private FinancierRepository financierRepository;

    public FinancierServices(FinancierRepository financierRepository) {
        this.financierRepository = financierRepository;
    }

    public Financier earningDay() {

        LocalDate today = LocalDate.now();

        return null;
    }

}
