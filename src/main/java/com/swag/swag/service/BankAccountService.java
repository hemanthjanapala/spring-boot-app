package com.swag.swag.service;

import com.swag.swag.models.BankAccount;
import com.swag.swag.repository.BankAccountRepository;
import com.swag.swag.repository.CustomerProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository accountRepository;

    @Autowired
    private CustomerProfileRepository customerRepository;

    // Create a new bank account
    public BankAccount createAccount(BankAccount account) {
        if (!customerRepository.existsById(account.getCustomer().getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Customer not found");
        }
        return accountRepository.save(account);
    }

    // Retrieve all bank accounts
    public List<BankAccount> getAllAccounts() {
        return accountRepository.findAll();
    }

    // Retrieve a bank account by ID
    public BankAccount getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Bank account not found"));
    }

    // Update a bank account
    public BankAccount updateAccount(Long id, BankAccount account) {
        BankAccount existingAccount = getAccountById(id);
        existingAccount.setAccountNumber(account.getAccountNumber());
        existingAccount.setBalance(account.getBalance());
        return accountRepository.save(existingAccount);
    }

    // Delete a bank account
    public void deleteAccount(Long id) {
        BankAccount account = getAccountById(id);
        accountRepository.delete(account);
    }
}

