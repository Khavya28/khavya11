package com.example.Insurance.Service;

import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Repository.InsuranceCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsuranceCategoryService {

    @Autowired
    private InsuranceCategoryRepo insuranceCategoryRepo;

    // Create a new category only if it exists
    public InsuranceCategory createCategory(InsuranceCategory category) {
        return insuranceCategoryRepo.save(category);
    }

    // Get all categories
    public List<InsuranceCategory> getAllCategories() {
        return insuranceCategoryRepo.findAll();
    }

    public InsuranceCategory getCategoryById(int id) {
        return insuranceCategoryRepo.findById(id).orElse(null);
    }
    // Update an existing category
    public InsuranceCategory updateCategory(int id, InsuranceCategory category) {
        return insuranceCategoryRepo.findById(id)
                .map(existingCategory -> {
                    existingCategory.setCategoryName(category.getCategoryName());
                    return insuranceCategoryRepo.save(existingCategory);
                }).orElse(null);
    }

    // Delete a category
    public String deleteCategory(int id) {
        if (insuranceCategoryRepo.existsById(id)) {
            insuranceCategoryRepo.deleteById(id);
            return "Category deleted successfully.";
        } else {
            return "Category not found.";
        }
    }
}
