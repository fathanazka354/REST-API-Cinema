package com.binar.cinema.service;

import com.binar.cinema.entity.*;
import com.binar.cinema.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.binar.cinema.service.PaymentServiceImpl.unwrapPayment;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    ShowTimeRepository showTimeRepository;
    @Override
    public Order getOrderById(Long id) {
        Optional<Order> entity = orderRepository.findById(id);
        return InvoiceServiceImpl.unwrapOrder(entity, id);
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

    @Override
    public Order addShowTimeToOrder(Long showTimeId, Long orderId) {
        Order order = getOrderById(orderId);
        Optional<ShowTime> showTime = showTimeRepository.findById(showTimeId);
        if (showTime.isPresent()){
            order.setShowTimes(showTime.get());
            return orderRepository.saveAndFlush(order);
        }
        return null;
    }

    @Override
    public Order addCustomerToOrder(Long customerId, Long orderId) {
        Order order = getOrderById(orderId);
        Optional<Customer> customer = customerRepository.findById(customerId);
        if (customer.isPresent()){
            order.setCustomer(customer.get());
            return orderRepository.saveAndFlush(order);
        }
        return null;
    }

    @Override
    public Order addEmployeeToOrder(Long employeeId, Long orderId) {
        Order order = getOrderById(orderId);
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        if (employee.isPresent()){
            order.setEmployee(employee.get());
            return orderRepository.saveAndFlush(order);
        }
        return null;
    }

    @Override
    public Order addPaymentToOrder(Long paymentId, Long orderId) {
        Optional<Order> entity = orderRepository.findById(orderId);
        Order order = InvoiceServiceImpl.unwrapOrder(entity, orderId);
        Optional<Payment> entityPayment = paymentRepository.findById(orderId);
        Payment payment = unwrapPayment(entityPayment, paymentId);
        order.setPayment(payment);
        return orderRepository.saveAndFlush(order);
    }
    @Override
    public ShowTime getEnrolledShowTime(Long orderId) {
        Optional<Order> entity = orderRepository.findById(orderId);
        Order order = InvoiceServiceImpl.unwrapOrder(entity, orderId);
        return order.getShowTimes();
    }

    @Override
    public Employee getEnrolledEmployee(Long orderId) {
        Optional<Order> entity = orderRepository.findById(orderId);
        Order order = InvoiceServiceImpl.unwrapOrder(entity, orderId);
        return order.getEmployee();
    }

    @Override
    public Customer getEnrolledCustomer(Long orderId) {
        Optional<Order> entity = orderRepository.findById(orderId);
        Order order = InvoiceServiceImpl.unwrapOrder(entity, orderId);
        return order.getCustomer();
    }

    @Override
    public Payment getEnrolledPayment(Long orderId) {
        Optional<Order> entity = orderRepository.findById(orderId);
        Order order = InvoiceServiceImpl.unwrapOrder(entity, orderId);
        return order.getPayment();
    }
}
