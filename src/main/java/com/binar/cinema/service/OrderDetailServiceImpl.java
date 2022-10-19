package com.binar.cinema.service;

import com.binar.cinema.entity.Order;
import com.binar.cinema.entity.OrderDetail;
import com.binar.cinema.exception.DataNotFoundException;
import com.binar.cinema.repository.OrderDetailRepository;
import com.binar.cinema.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.binar.cinema.service.InvoiceServiceImpl.unwrapOrder;

@Service
public class OrderDetailServiceImpl implements OrderDetailService{
    @Autowired
    OrderDetailRepository orderDetailRepository;
    @Autowired
    OrderRepository orderRepository;
    @Override
    public OrderDetail getOrderDetailById(Long id) {
        Optional<OrderDetail> entity = orderDetailRepository.findById(id);
        return unwrapOrderDetail(entity, id);
    }

    @Override
    public OrderDetail saveOrderDetail(Long orderDetailId,Long orderId) {
        Optional<Order> entity = orderRepository.findById(orderId);
        Order order = unwrapOrder(entity, orderId);
        OrderDetail orderDetail = getOrderDetailById(orderDetailId);
        String seatId = order.getShowTimes().getSeat().getSeatCode();
        String firstName = order.getCustomer().getFirstName();
        String lastName = order.getCustomer().getLastName();
        orderDetail.setCodeSeat(seatId);
        orderDetail.setFirstName(firstName);
        orderDetail.setLastName(lastName);
        orderDetail.setOrder(order);
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

    static OrderDetail unwrapOrderDetail(Optional<OrderDetail> entity, Long id){
        if (entity.isPresent()) return entity.get();
        throw new DataNotFoundException(id);
    }
}
