package com.yragurman.service;

import com.yragurman.domain.Customer;
import com.yragurman.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements AbstractService<Customer, Integer>{

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(Integer id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer create(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

    @Override
    public Customer update(Integer id, Customer customer) {
        if (customerRepository.findById(id).isPresent()) {
            return customerRepository.save(customer);
        } else {
            return null;
        }
    }

    @Override
    public Boolean deleteById(Integer id) {
        if (customerRepository.findById(id).isPresent()) {
            customerRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

}
