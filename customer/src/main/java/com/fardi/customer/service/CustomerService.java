package com.fardi.customer.service;


import com.fardi.customer.entity.Customer;
import com.fardi.customer.entity.Role;
import com.fardi.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;




    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findByCustomerId(String id) {
        return customerRepository.findById(id).orElse(null);
    }


    @Override
    public Customer saveOrUpdateCustomer(Customer customer) {
        if(customerRepository.findAll().isEmpty())
            customer.setRole(Role.ADMIN);
        else
            customer.setRole(Role.USER);
        customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    public Customer findByEmail(String email) {
        return customerRepository.findCustomerByEmail(email);
    }

}
