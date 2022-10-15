package com.binar.cinema.service;

import com.binar.cinema.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    Order getOrderById(Long id);
    Order saveOrder(Order order);
    List<Order> getAllOrder();
    void deleteOrder(Long id);
}
