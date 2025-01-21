package com.swag.swag.repository;




import com.swag.swag.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    // Add custom query methods if needed
}

