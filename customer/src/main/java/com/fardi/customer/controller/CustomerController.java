package com.fardi.customer.controller;


import com.fardi.customer.entity.Customer;
import com.fardi.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("")
    public List<Customer> getAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") String id) {
        try{
            Optional<Customer> customer = Optional.ofNullable(customerService.findByCustomerId(id));
            return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity saveCustomer(@RequestBody Customer customer) {
        try{
            Customer newCustomer = customerService.saveOrUpdateCustomer(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("duplicate key email or phone");
        }
    }

    @PutMapping("")
    public ResponseEntity updateCustomer(@RequestBody Customer customer) {
        try{
            Customer newCustomer = customerService.saveOrUpdateCustomer(customer);
            return new ResponseEntity<>(newCustomer, HttpStatus.OK);
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.CONFLICT).body("duplicate key email or phone");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deleteCustomer(@PathVariable("id") String id) {
        try{
            if(customerService.findByCustomerId(id) == null)
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            customerService.deleteCustomerById(id);
            return ResponseEntity.status(HttpStatus.OK).body("delete success");
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
