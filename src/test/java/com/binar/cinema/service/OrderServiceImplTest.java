package com.binar.cinema.service;

import com.binar.cinema.entity.Order;
import com.binar.cinema.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class OrderServiceImplTest {
    @Mock
    OrderRepository orderRepository;

    @InjectMocks OrderServiceImpl orderService;

    Order order= new Order();
    @BeforeEach
    void setUp(){
    }

    @Test
    void getOrderById() {
    }

    @Test
    void saveOrder() {
    }

    @Test
    void getAllOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void addShowTimeToOrder() {
    }

    @Test
    void addCustomerToOrder() {
    }

    @Test
    void addEmployeeToOrder() {
    }

    @Test
    void addPaymentToOrder() {
    }

    @Test
    void getEnrolledShowTime() {
    }

    @Test
    void getEnrolledEmployee() {
    }

    @Test
    void getEnrolledCustomer() {
    }

    @Test
    void getEnrolledPayment() {
    }
}