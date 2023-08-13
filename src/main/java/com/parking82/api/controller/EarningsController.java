package com.parking82.api.controller;

import com.parking82.api.services.EarningsServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/financerio")
public class EarningsController {

    private EarningsServices earningsServices;
    public EarningsController(EarningsServices earningsServices) {
        this.earningsServices = earningsServices;
    }

}
