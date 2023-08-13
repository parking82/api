package com.parking82.api.services;

import com.parking82.api.respository.EarningsRepository;
import org.springframework.stereotype.Service;

@Service
public class EarningsServices {

    private EarningsRepository earningsRepository;

    public EarningsServices(EarningsRepository earningsRepository) {
        this.earningsRepository = earningsRepository;
    }


}
