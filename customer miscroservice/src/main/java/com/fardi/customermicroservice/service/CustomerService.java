package com.fardi.customermicroservice.service;


import com.fardi.customermicroservice.entity.Customer;
import com.fardi.customermicroservice.entity.Role;
import com.fardi.customermicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    ApplicationContext context;




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
        PasswordEncoder bcryptPasswordEncoder = context.getBean(PasswordEncoder.class);
        if(customerRepository.findAll().isEmpty())
            customer.setRole(Role.ADMIN);
        else
            customer.setRole(Role.USER);
        customer.setPassword(bcryptPasswordEncoder.encode(customer.getPassword()));
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
