package com.example.Insurance.Repository;

import com.example.Insurance.Model.BusinessInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusinessInsuranceRepo extends JpaRepository<BusinessInsurance, Long> {
    @Query("SELECT bi FROM BusinessInsurance bi WHERE bi.customer.cid = :customerId")
    List<BusinessInsurance> findByCustomerId(Integer customerId);
}