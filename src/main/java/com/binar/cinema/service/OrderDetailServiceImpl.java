package com.binar.cinema.service;

import com.binar.cinema.entity.Order;
import com.binar.cinema.entity.OrderDetail;
import com.binar.cinema.repository.OrderDetailRepository;
import com.binar.cinema.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public OrderDetail saveOrderDetail(Long orderDetailId,Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        if (order.isPresent()){
            OrderDetail orderDetail = getOrderDetailById(orderDetailId);
            String seatId = order.get().getShowTimes().getSeat().getSeatCode();
            String firstName = order.get().getCustomer().getFirstName();
            System.out.println(firstName);
            String lastName = order.get().getCustomer().getLastName();
            System.out.println(lastName);
            orderDetail.setCodeSeat(seatId);
            orderDetail.setFirstName(firstName);
            orderDetail.setLastName(lastName);
            orderDetail.setOrder(order.get());
            return orderDetailRepository.saveAndFlush(orderDetail);
        }
        return null;
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
