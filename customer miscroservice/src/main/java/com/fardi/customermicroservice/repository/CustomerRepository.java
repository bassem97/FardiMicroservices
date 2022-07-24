package com.fardi.customermicroservice.repository;


import com.fardi.customermicroservice.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {


    Optional<Customer> findById(String id);
    Customer findCustomerByEmail(String email);

}
