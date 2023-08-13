package com.parking82.api.services;

import com.parking82.api.respository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class FinancierServices {

    private PaymentRepository paymentRepository;

    public FinancierServices(PaymentRepository paymentRepository) {
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
