package com.example.Insurance.Repository;

import com.example.Insurance.Model.InsurancePlanType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface InsurancePlanTypeRepo extends JpaRepository<InsurancePlanType, Integer> {
    List<InsurancePlanType> findByCategoryId(Integer categoryId); // Add this method
}