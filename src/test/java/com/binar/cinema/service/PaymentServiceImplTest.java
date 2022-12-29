package com.binar.cinema.service;

import com.binar.cinema.entity.Payment;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PaymentServiceImplTest {

    @Mock
    PaymentRepository paymentRepository;
    @InjectMocks PaymentServiceImpl paymentService;
    Payment payment = new Payment();
    @BeforeEach
    private void setUp() throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2022-07-12 20:20:20");
        payment.setPaymentId(1L);
        payment.setCash(12000.0);
        payment.setCreatedAt(date);
        payment.setUpdatedAt(null);
    }
    @Test
    void getPaymentByIdReturnFalse() {
        when(paymentRepository.findById(0L)).thenReturn(Optional.ofNullable(null));
        Throwable paymentbyId = assertThrows(DataNotFoundException.class, ()->paymentService.getPaymentById(0L));
        assertNotEquals("Index: 0, Size: 0", paymentbyId);
    }

    @Test
    void getPaymentById() {
        when(paymentRepository.findById(1L)).thenReturn(Optional.ofNullable(payment));
        Payment paymentbyId = paymentService.getPaymentById(1L);
        assertEquals(paymentbyId, payment);
    }

    @Test
    void savePayment() {
        when(paymentRepository.saveAndFlush(payment)).thenReturn(payment);
        var paymentSave = paymentService.savePayment(payment);
        assertEquals(paymentSave, payment);
    }
    @Test
    void savePaymentReturnFalse() {
        when(paymentRepository.saveAndFlush(null)).thenReturn(null);
        var paymentSave = paymentService.savePayment(null);
        assertNull(paymentSave);
    }


    @Test
    void getAllPayment() {
        List<Payment> payments = new ArrayList<>();
        payments.add(payment);
        when(paymentRepository.findAll()).thenReturn(payments);
        var paymentAll = paymentService.getAllPayment();
        assertEquals(paymentAll, payments);
    }

    @Test
    void getAllPaymentReturnFalse() {
        List<Payment> payments = new ArrayList<>();
        payments.add(null);
        when(paymentRepository.findAll()).thenReturn(null);
        var paymentAll = paymentService.getAllPayment();
        assertNull(paymentAll);
    }

    @Test
    void deletePayment() {
        paymentService.deletePayment(1L);
        verify(paymentRepository).deleteById(1L);
    }

    @Test
    void deletePaymentReturnFalse() {
        paymentService.deletePayment(null);
        verify(paymentRepository).deleteById(null);
    }
}