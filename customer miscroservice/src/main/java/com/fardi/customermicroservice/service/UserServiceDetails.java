package com.fardi.customermicroservice.service;

import com.fardi.customermicroservice.entity.MyUserDetails;
import com.fardi.customermicroservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service

@ComponentScan("com.fardi.customermicroservice.repository")
public class UserServiceDetails implements UserDetailsService {
    @Autowired
    private CustomerRepository customerRespository;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return new MyUserDetails(customerRespository.findCustomerByEmail(userName));
    }


    @Bean
    public BCryptPasswordEncoder  bcryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }


}