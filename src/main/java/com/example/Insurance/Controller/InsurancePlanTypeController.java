package com.example.Insurance.Controller;

import com.example.Insurance.Model.InsurancePlanType;
import com.example.Insurance.Service.InsurancePlanTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/insurance_plan_type")
public class InsurancePlanTypeController {
    @Autowired
    private InsurancePlanTypeService insurancePlanTypeService;

    @GetMapping("/{id}")
    public Optional<InsurancePlanType> getPlanTypeById(@PathVariable("id") int id) {
        return insurancePlanTypeService.getPlanTypeById(id);
    }

    @GetMapping("/all")
    public List<InsurancePlanType> getAllPlanTypes() {
        return insurancePlanTypeService.getAllPlanTypes();
    }
}