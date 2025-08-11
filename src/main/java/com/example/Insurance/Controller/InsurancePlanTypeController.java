package com.example.Insurance.Controller;

import com.example.Insurance.Model.InsurancePlanType;
import com.example.Insurance.Service.InsurancePlanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/insurance_plan_type")
public class InsurancePlanTypeController {

    @Autowired
    private InsurancePlanTypeService insurancePlanTypeService;

    @GetMapping("/all")
    public List<InsurancePlanType> getAllPlanTypes() {
        return insurancePlanTypeService.getAllPlanTypes();
    }

    @GetMapping("/by-category/{categoryId}")
    public List<InsurancePlanType> getPlanTypesByCategoryId(@PathVariable Integer categoryId) {
        return insurancePlanTypeService.getPlanTypesByCategoryId(categoryId); // Fetch plans by category ID
    }

    @GetMapping("/{id}")
    public InsurancePlanType getPlanTypeById(@PathVariable int id) {
        return insurancePlanTypeService.getPlanTypeById(id);
    }

    @PostMapping("/create")
    public InsurancePlanType createPlanType(@RequestBody InsurancePlanType planType) {
        return insurancePlanTypeService.savePlanType(planType);
    }

    @DeleteMapping("/delete/{id}")
    public String deletePlanType(@PathVariable int id) {
        return insurancePlanTypeService.deletePlanType(id);
    }
}