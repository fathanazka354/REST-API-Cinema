package com.binar.cinema.service;

import com.binar.cinema.entity.OrderDetail;
import com.binar.cinema.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Override
    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.saveAndFlush(orderDetail);
    }

    @Override
    public List<OrderDetail> getAllOrder() {
        return orderDetailRepository.findAll();
    }

    @Override
    public void deleteOrderDetail(Long id) {
        orderDetailRepository.deleteById(id);
    }
}
