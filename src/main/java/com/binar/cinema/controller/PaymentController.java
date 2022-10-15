package com.binar.cinema.controller;

import com.binar.cinema.entity.Payment;
import com.binar.cinema.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;
    @GetMapping("/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id){
        return new ResponseEntity<>(paymentService.getPaymentById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Payment>> getPayments(){
        return new ResponseEntity<>(paymentService.getAllPayment(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Payment> postOrderDetail(@RequestBody Payment payment){
        return new ResponseEntity<>(paymentService.savePayment(payment), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrderDetail(@PathVariable Long id){
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
