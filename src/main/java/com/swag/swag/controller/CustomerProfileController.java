package com.swag.swag.controller;



import com.swag.swag.models.CustomerProfile;
import com.swag.swag.service.CustomerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService service;

    // Create a new customer
    @PostMapping
    public ResponseEntity<CustomerProfile> createCustomer(@RequestBody CustomerProfile customer) {
        return new ResponseEntity<>(service.createCustomer(customer), HttpStatus.CREATED);
    }

    // Get all customers
    @GetMapping
    public List<CustomerProfile> getAllCustomers() {
        return service.getAllCustomers();
    }

    // Get a customer by ID
    @GetMapping("/{id}")
    public CustomerProfile getCustomerById(@PathVariable Long id) {
        return service.getCustomerById(id);
    }

    // Update a customer by ID
    @PutMapping("/{id}")
    public CustomerProfile updateCustomer(@PathVariable Long id, @RequestBody CustomerProfile customer) {
        return service.updateCustomer(id, customer);
    }

    // Delete a customer by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Long id) {
        service.deleteCustomer(id);
    }
}

