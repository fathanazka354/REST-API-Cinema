package com.binar.cinema.service;

import com.binar.cinema.entity.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderDetailService {
    OrderDetail getOrderDetailById(Long id);
    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> getAllOrder();
    void deleteOrderDetail(Long id);
}
