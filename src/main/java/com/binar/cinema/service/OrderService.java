package com.binar.cinema.service;

import com.binar.cinema.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order getOrderById(Long id);
    Order saveOrder(Order order);
    List<Order> getAllOrder();
    void deleteOrder(Long id);
    Order addShowTimeToOrder(Long showTimeId, Long orderId);
    Order addCustomerToOrder(Long customerId, Long orderId);
    Order addEmployeeToOrder(Long employeeId, Long orderId);
    Order addPaymentToOrder(Long paymentId, Long orderId);
    ShowTime getEnrolledShowTime(Long orderId);
    Employee getEnrolledEmployee(Long orderId);
    Customer getEnrolledCustomer(Long orderId);
    Payment getEnrolledPayment(Long orderId);
}
