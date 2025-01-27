package com.example.Insurance.Repository;

import com.example.Insurance.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

    Customer findByPhone(String phone);

    Customer findbyEmail(String email);
}
