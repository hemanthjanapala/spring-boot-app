package com.swag.swag.repository;




import com.swag.swag.models.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
    // Add custom query methods if needed
}
