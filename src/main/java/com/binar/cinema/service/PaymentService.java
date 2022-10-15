package com.binar.cinema.service;

import com.binar.cinema.entity.Payment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PaymentService {
    Payment getPaymentById(Long id);
    Payment savePayment(Payment payment);
    List<Payment> getAllPayment();
    void deletePayment(Long id);
}
