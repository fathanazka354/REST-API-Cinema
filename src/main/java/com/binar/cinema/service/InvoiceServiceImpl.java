package com.binar.cinema.service;

import com.binar.cinema.dto.Invoice;
import com.binar.cinema.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    OrderService orderService;

    @Override
    public Invoice getInvoiceById(Long orderId) {
        Invoice invoice = new Invoice();
        Order order = orderService.getOrderById(orderId);
        invoice.setFirstName(order.getCustomer().getFirstName());
        invoice.setCustomerId(order.getCustomer().getCustomerId());
        invoice.setSeatCode(order.getShowTimes().getSeat().getSeatCode());
        invoice.setCash(order.getPayment().getCash());
        invoice.setMovieName(order.getShowTimes().getMovie().getMovieName());
        invoice.setDateShowtime(order.getShowTimes().getDateShowtime());
        return invoice;
    }

}
