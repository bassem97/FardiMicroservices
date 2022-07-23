package com.fardi.customer.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Customers") @Data
public class Customer {
    @Id
    public String id;

    public String firstName;
    public String lastName;

    @Indexed(unique = true, background = true)
    public String email;
    public String password;

    @Indexed(unique = true, background = true)
    public String phone;

}
