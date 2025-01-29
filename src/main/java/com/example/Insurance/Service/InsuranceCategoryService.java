package com.example.Insurance.Service;

import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Repository.InsuranceCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsuranceCategoryService {
    @Autowired
    private InsuranceCategoryRepo insurancecategoryrepo;

    public Optional<InsuranceCategory> getCategoryById(int id) {
        return insurancecategoryrepo.findById(id);
    }

    public List<InsuranceCategory> getAllCategories() {
        return insurancecategoryrepo.findAll();
    }
}
