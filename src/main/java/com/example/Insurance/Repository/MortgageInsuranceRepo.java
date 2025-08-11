package com.example.Insurance.Repository;

import com.example.Insurance.Model.MortgageInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MortgageInsuranceRepo extends JpaRepository<MortgageInsurance, Long> {
}
