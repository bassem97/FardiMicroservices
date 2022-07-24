package com.fardi.customermicroservice.util;


import com.fardi.customermicroservice.entity.Customer;

public class JwtRespone {
    private String token;

    private Customer customer;

    public JwtRespone(String token,Customer customer) {
        this.token = token;
        this.customer = customer;
    }

    public JwtRespone() {
    }

    public String getToken() {
        return token;
    }

    public Customer getUser() {
        return customer;
    }

    public void setUser(Customer customer) {
        this.customer = customer;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
