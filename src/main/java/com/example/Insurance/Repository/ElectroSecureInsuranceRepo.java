package com.example.Insurance.Repository;

import com.example.Insurance.Model.ElectroSecureInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElectroSecureInsuranceRepo extends JpaRepository<ElectroSecureInsurance, Long> {
    @Query("SELECT esi FROM ElectroSecureInsurance esi WHERE esi.customer.cid = :customerId")
    List<ElectroSecureInsurance> findByCustomerId(Integer customerId);
}

