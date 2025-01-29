package com.example.Insurance.Repository;

import com.example.Insurance.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findByPhone(String phone);

    Customer findByEmail(String email);
    Optional<Customer> findByEmailAndPassword(String email, String password);
}

