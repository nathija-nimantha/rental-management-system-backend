package com.millenniumhardware.web.service.impl;

import com.millenniumhardware.web.dto.CustomerDTO;
import com.millenniumhardware.web.entity.Customer;
import com.millenniumhardware.web.repository.CustomerRepository;
import com.millenniumhardware.web.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CustomerDTO create(CustomerDTO customerDTO) {
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);
        return modelMapper.map(savedCustomer, CustomerDTO.class);
    }

    @Override
    public CustomerDTO getById(String id) {
        Customer customer = customerRepository.findById(Integer.valueOf(id))
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
        return modelMapper.map(customer, CustomerDTO.class);
    }

    @Override
    public List<CustomerDTO> getAll() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream()
                .map(customer -> modelMapper.map(customer, CustomerDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public CustomerDTO update(String id, CustomerDTO customerDTO) {
        if (!customerRepository.existsById(Integer.valueOf(id))) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        customer.setCustomerId(Integer.parseInt(id));
        Customer updatedCustomer = customerRepository.save(customer);
        return modelMapper.map(updatedCustomer, CustomerDTO.class);
    }

    @Override
    public void delete(String id) {
        if (!customerRepository.existsById(Integer.valueOf(id))) {
            throw new RuntimeException("Customer not found with ID: " + id);
        }customerRepository.deleteById(Integer.valueOf(id));
    }
}
