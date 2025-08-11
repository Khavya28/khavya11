package com.example.Insurance.Repository;

import com.example.Insurance.Model.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface InsurancePolicyRepo extends JpaRepository<InsurancePolicy, Integer> {

    List<InsurancePolicy> findByCustomerCid(int cid);
    Optional<InsurancePolicy> findPolicyWithDetailsById(int id);
    @Query("SELECT ip FROM InsurancePolicy ip WHERE ip.customer.cid = :customerId")
    List<InsurancePolicy> findByCustomerId(@Param("customerId") int customerId);

}



