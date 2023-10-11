package com.parking82.api.services;

import com.parking82.api.respository.PagamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancierServices {

    private PagamentoRepository paymentRepository;

    public FinancierServices(PagamentoRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Double sumDayPayment(String data) {
        return paymentRepository.sumDayPayment(data);
    }

    public Double sumAllDate(String startDate, String endDate) {
        return paymentRepository.sumAllDate(startDate, endDate);
    }

    public Double sumAll() {
        return paymentRepository.sumAll();
    }

}
