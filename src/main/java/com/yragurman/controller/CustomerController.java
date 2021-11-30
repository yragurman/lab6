package com.yragurman.controller;

import com.yragurman.domain.Customer;
import com.yragurman.dto.CustomerDto;
import com.yragurman.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/customers")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<CustomerDto>> getAll() {
        List<Customer> customers = customerService.getAll();
        List<CustomerDto> customerDtos = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDto customerDto = new CustomerDto(
                    customer.getId(),
                    customer.getVehicleNumber(),
                    customer.getIsRegularCustomer(),
                    customer.getContactNumber()
            );
            customerDtos.add(customerDto);
        }
        return new ResponseEntity<>(customerDtos, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<CustomerDto> getById(@PathVariable Integer id) {
        Customer customer;
        try {
            customer = customerService.getById(id);

            CustomerDto customerDto = new CustomerDto(
                    customer.getId(),
                    customer.getVehicleNumber(),
                    customer.getIsRegularCustomer(),
                    customer.getContactNumber()
            );
            return new ResponseEntity<>(customerDto, HttpStatus.OK);


        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Void> create(@RequestBody Customer newCustomer) {
        customerService.create(newCustomer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<CustomerDto> update(@PathVariable Integer id, @RequestBody Customer customer) {
        Customer customerOld;
        try {
            customerOld = customerService.getById(id);

            if (customerOld != null) {
                customerService.update(id, customer);
                CustomerDto customerOldDto = new CustomerDto(
                        customerOld.getId(),
                        customerOld.getVehicleNumber(),
                        customerOld.getIsRegularCustomer(),
                        customerOld.getContactNumber()
                );
                return new ResponseEntity<>(customerOldDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        if (customerService.deleteById(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
