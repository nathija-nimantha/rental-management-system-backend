package com.millenniumhardware.web.service;

import com.millenniumhardware.web.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO create(CustomerDTO customerDTO);
    CustomerDTO getById(String id);
    List<CustomerDTO> getAll();
    CustomerDTO update(String id, CustomerDTO customerDTO);
    void delete(String id);
}
