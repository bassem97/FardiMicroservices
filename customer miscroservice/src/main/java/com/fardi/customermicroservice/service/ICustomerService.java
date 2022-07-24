package com.fardi.customermicroservice.service;



import com.fardi.customermicroservice.entity.Customer;

import java.util.List;

public interface ICustomerService  {

    List<Customer> findAll();

    Customer findByCustomerId(String id);

    Customer saveOrUpdateCustomer(Customer student);

    void deleteCustomerById(String id);
}
