package com.binar.cinema.service;

import com.binar.cinema.entity.OrderDetail;
import com.binar.cinema.entity.Payment;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService{
    @Autowired
    PaymentRepository paymentRepository;
    @Override
    public Payment getPaymentById(Long id) {
        Optional<Payment> entity = paymentRepository.findById(id);
        return unwrapPayment(entity, id);
    }

    @Override
    public Payment savePayment(Payment payment) {
        return paymentRepository.saveAndFlush(payment);
    }

    @Override
    public List<Payment> getAllPayment() {
        return paymentRepository.findAll();
    }

    @Override
    public void deletePayment(Long id) {
        paymentRepository.deleteById(id);
    }

    static Payment unwrapPayment(Optional<Payment> entity, Long id){
        if (entity.isPresent()) return entity.get();
        throw new DataNotFoundException(id);
    }
}
