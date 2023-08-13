package com.parking82.api.controller;

import com.parking82.api.services.FinancierServices;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financeiro")
public class FinancierController {

    private FinancierServices financierServices;

    public FinancierController(FinancierServices financierServices) {
        this.financierServices = financierServices;
    }

    @GetMapping("/dia")
    public Double today(@RequestParam(name = "data") String data) {
        return financierServices.sumDayPayment(data);
    }

    @GetMapping("/personalizado")
    public Double sumAllDate(@RequestParam(name = "start") String startDate, @RequestParam(name = "end") String endDate) {
        return financierServices.sumAllDate(startDate, endDate);
    }

    @GetMapping("/todo-periodo")
    public Double sumAll() {
        return financierServices.sumAll();
    }
}
