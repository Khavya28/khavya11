package com.example.Insurance.Repository;

import com.example.Insurance.Model.Insurance_Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepo extends JpaRepository<Insurance_Policy,Integer> {
}
