package com.parking82.api.services;

import com.parking82.api.respository.FinancierRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancierServices {

    private FinancierRepository financierRepository;

    public FinancierServices(FinancierRepository financierRepository) {
        this.financierRepository = financierRepository;
    }


}
