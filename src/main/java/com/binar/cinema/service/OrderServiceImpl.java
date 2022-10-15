package com.binar.cinema.service;

import com.binar.cinema.entity.Order;
import com.binar.cinema.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
