package com.example.customer.services;

import com.example.customer.dtos.CustomerDTO;
import java.util.List;


public interface CustomerService {

    List<CustomerDTO> findAll();
    CustomerDTO findById(Long id);
}