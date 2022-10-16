package com.binar.cinema.controller;

import com.binar.cinema.entity.*;
import com.binar.cinema.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){
        return new ResponseEntity<>(orderService.getAllOrder(), HttpStatus.OK);
    }

    @GetMapping("/{orderId}/customer")
    public ResponseEntity<Customer> getEnrolledCustomer(@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.getEnrolledCustomer(orderId), HttpStatus.OK);
    }

    @GetMapping("/{orderId}/employee")
    public ResponseEntity<Employee> getEnrolledEmployee(@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.getEnrolledEmployee(orderId), HttpStatus.OK);
    }

    @GetMapping("/{orderId}/payment")
    public ResponseEntity<Payment> getEnrolledPayment(@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.getEnrolledPayment(orderId), HttpStatus.OK);
    }

    @GetMapping("/{orderId}/showtime")
    public ResponseEntity<ShowTime> getEnrolledShowTime(@PathVariable Long orderId){
        return new ResponseEntity<>(orderService.getEnrolledShowTime(orderId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Order> postOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @PutMapping("/{orderId}/customer/{customerId}")
    public ResponseEntity<Order> addCustomerToOrder(@PathVariable Long orderId, @PathVariable Long customerId){
        return new ResponseEntity<>(orderService.addCustomerToOrder(customerId, orderId), HttpStatus.OK);
    }

    @PutMapping("/{orderId}/showtime/{showtimeId}")
    public ResponseEntity<Order> addShowTimeToOrder(@PathVariable Long orderId, @PathVariable Long showtimeId){
        return new ResponseEntity<>(orderService.addShowTimeToOrder(showtimeId, orderId), HttpStatus.OK);
    }

    @PutMapping("/{orderId}/employee/{employeeId}")
    public ResponseEntity<Order> addEmployeeToOrder(@PathVariable Long orderId, @PathVariable Long employeeId){
        return new ResponseEntity<>(orderService.addEmployeeToOrder(employeeId, orderId), HttpStatus.OK);
    }

    @PutMapping("/{orderId}/payment/{paymentId}")
    public ResponseEntity<Order> addPaymentToOrder(@PathVariable Long orderId, @PathVariable Long paymentId){
        return new ResponseEntity<>(orderService.addPaymentToOrder(paymentId, orderId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
