package com.binar.cinema.controller;

import com.binar.cinema.entity.Order;
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

    @PostMapping
    public ResponseEntity<Order> postOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.saveOrder(order), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable Long id){
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
