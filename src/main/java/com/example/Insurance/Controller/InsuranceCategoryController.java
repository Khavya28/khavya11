package com.example.Insurance.Controller;

import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Service.InsuranceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/insurance_category")
public class InsuranceCategoryController {
    @Autowired
    private InsuranceCategoryService insuranceCategoryService;
    @PostMapping("/create")
    public InsuranceCategory createCategory(@RequestBody InsuranceCategory category) {
        return insuranceCategoryService.createCategory(category);
    }

    // Get all categories
    @GetMapping("/all")
    public List<InsuranceCategory> getAllCategories() {
        return insuranceCategoryService.getAllCategories();
    }

    // Get category by ID
    @GetMapping("/{id}")
    public InsuranceCategory getCategoryById(@PathVariable int id) {
        return insuranceCategoryService.getCategoryById(id);
    }

    // Update an existing category
    @PutMapping("/update/{id}")
    public InsuranceCategory updateCategory(@PathVariable int id, @RequestBody InsuranceCategory category) {
        return insuranceCategoryService.updateCategory(id, category);
    }

    // Delete a category
    @DeleteMapping("/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        return insuranceCategoryService.deleteCategory(id);
    }
}


