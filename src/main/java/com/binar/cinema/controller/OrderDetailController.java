package com.binar.cinema.controller;

import com.binar.cinema.entity.OrderDetail;
import com.binar.cinema.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-detail")
public class OrderDetailController {
    @Autowired
    OrderDetailService orderDetailService;
    @GetMapping("/{id}")
    public ResponseEntity<OrderDetail> getOrderDetailById(@PathVariable Long id){
        return new ResponseEntity<>(orderDetailService.getOrderDetailById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderDetail>> getOrderDetails(){
        return new ResponseEntity<>(orderDetailService.getAllOrder(), HttpStatus.OK);
    }

    @PutMapping("/{orderDetailId}/order/{orderId}")
    public ResponseEntity<OrderDetail> postOrderDetail(@PathVariable Long orderDetailId,@PathVariable Long orderId){
        return new ResponseEntity<>(orderDetailService.saveOrderDetail(orderDetailId,orderId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteOrderDetail(@PathVariable Long id){
        orderDetailService.deleteOrderDetail(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
