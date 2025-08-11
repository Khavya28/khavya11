package com.example.Insurance.Repository;

import com.example.Insurance.Model.LifeHealthInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LifeHealthInsuranceRepo extends JpaRepository<LifeHealthInsurance, Long> {
    @Query("SELECT lhi FROM LifeHealthInsurance lhi WHERE lhi.customer.cid = :customerId")
    List<LifeHealthInsurance> findByCustomerId(Integer customerId);
}