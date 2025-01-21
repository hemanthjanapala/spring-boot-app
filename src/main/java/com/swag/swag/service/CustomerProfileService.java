package com.swag.swag.service;

import com.swag.swag.models.CustomerProfile;
import com.swag.swag.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class CustomerProfileService {

    @Autowired
    private CustomerProfileRepository repository;

    // Create a new customer profile
    public CustomerProfile createCustomer(CustomerProfile customer) {
        return repository.save(customer);
    }

    // Retrieve all customer profiles
    public List<CustomerProfile> getAllCustomers() {
        return repository.findAll();
    }

    // Retrieve a customer profile by ID
    public CustomerProfile getCustomerById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
    }

    // Update an existing customer profile
    public CustomerProfile updateCustomer(Long id, CustomerProfile customer) {
        CustomerProfile existingCustomer = getCustomerById(id);
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        return repository.save(existingCustomer);
    }

    // Delete a customer profile by ID
    public void deleteCustomer(Long id) {
        CustomerProfile customer = getCustomerById(id);
        repository.delete(customer);
    }
}

