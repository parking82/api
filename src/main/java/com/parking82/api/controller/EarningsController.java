package com.parking82.api.controller;

import com.parking82.api.services.FinancierServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financerio")
public class EarningsController {

    private FinancierServices financierServices;
    public EarningsController(FinancierServices financierServices) {
        this.financierServices = financierServices;
    }

}
