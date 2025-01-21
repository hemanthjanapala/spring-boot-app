package com.swag.swag.controller;



import com.swag.swag.models.BankAccount;
import com.swag.swag.service.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService service;

    // Create a new bank account
    @PostMapping
    public ResponseEntity<BankAccount> createAccount(@RequestBody BankAccount account) {
        return new ResponseEntity<>(service.createAccount(account), HttpStatus.CREATED);
    }

    // Get all bank accounts
    @GetMapping
    public List<BankAccount> getAllAccounts() {
        return service.getAllAccounts();
    }

    // Get a bank account by ID
    @GetMapping("/{id}")
    public BankAccount getAccountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }

    // Update a bank account
    @PutMapping("/{id}")
    public BankAccount updateAccount(@PathVariable Long id, @RequestBody BankAccount account) {
        return service.updateAccount(id, account);
    }

    // Delete a bank account
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
    }
}

