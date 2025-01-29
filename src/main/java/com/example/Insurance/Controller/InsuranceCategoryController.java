package com.example.Insurance.Controller;

import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Service.InsuranceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insurance_category")
public class InsuranceCategoryController {
    @Autowired
    private InsuranceCategoryService insuranceCategoryService;

    @GetMapping("/{id}")
    public Optional<InsuranceCategory> getCategoryById(@PathVariable("id") int id) {
        return insuranceCategoryService.getCategoryById(id);
    }

    @GetMapping("/all")
    public List<InsuranceCategory> getAllCategories() {
        return insuranceCategoryService.getAllCategories();
    }
}
