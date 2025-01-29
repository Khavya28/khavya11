package com.example.Insurance.Repository;

import com.example.Insurance.Model.Insurance_Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InsurancePolicyRepo extends JpaRepository<Insurance_Policy,Integer> {
    @Query("SELECT ip.id AS policyId, ip.policyName, ip.policyholdername, " +
            "ic.categoryName, ipt.planType, ipt.premiumAmount, ipt.coverageAmount, ipt.tenure " +
            "FROM Insurance_Policy ip " +
            "JOIN ip.customer c " +
            "JOIN ip.insurancePlanType ipt " +
            "JOIN ipt.insuranceCategory ic " +
            "WHERE ip.id = :id")
    Optional<Object[]> findPolicyWithDetailsById(@Param("id") int id);
}
