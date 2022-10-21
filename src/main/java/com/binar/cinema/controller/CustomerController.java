package com.binar.cinema.controller;

import com.binar.cinema.dto.ResponseData;
import com.binar.cinema.entity.Customer;
import com.binar.cinema.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
//    @CrossOrigin(origins = "https://rest-api-cinema-production.up.railway.app",maxAge = 3600, allowCredentials = "true")
    public ResponseEntity<ResponseData<Customer>> getCustomerById(@PathVariable Long id){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(true);
        responseData.setPayload(customerService.getCustomerById(id));
        return ResponseEntity.ok(responseData);
    }

    @GetMapping
//    @CrossOrigin(origins = "https://rest-api-cinema-production.up.railway.app",maxAge = 3600, allowCredentials = "true")
    public ResponseEntity<ResponseData<List<Customer>>> getCustomers(){
        ResponseData responseData = new ResponseData();
        responseData.setStatus(true);
        responseData.setPayload(customerService.getAllCustomer());
        return ResponseEntity.ok(responseData);
    }

    @PostMapping
    public ResponseEntity<Customer> postCustomer(@Valid @RequestBody Customer customer){
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
