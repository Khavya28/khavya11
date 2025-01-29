package com.example.Insurance.Repository;

import com.example.Insurance.Model.InsuranceCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceCategoryRepo extends JpaRepository<InsuranceCategory, Integer> {}
