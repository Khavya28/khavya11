package com.example.Insurance.Service;

import com.example.Insurance.Model.InsurancePlanType;
import com.example.Insurance.Repository.InsurancePlanTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurancePlanTypeService {

    @Autowired
    private InsurancePlanTypeRepo insurancePlantyperepo;

    public List<InsurancePlanType> getAllPlanTypes() {
        return insurancePlantyperepo.findAll();
    }

    public List<InsurancePlanType> getPlanTypesByCategoryId(Integer categoryId) {
        return insurancePlantyperepo.findByCategoryId(categoryId); // Fetch plans by category ID
    }

    public InsurancePlanType getPlanTypeById(int id) {
        Optional<InsurancePlanType> planType = insurancePlantyperepo.findById(id);
        return planType.orElse(null);
    }

    public InsurancePlanType savePlanType(InsurancePlanType planType) {
        return insurancePlantyperepo.save(planType);
    }

    public String deletePlanType(int id) {
        if (insurancePlantyperepo.existsById(id)) {
            insurancePlantyperepo.deleteById(id);
            return "Insurance plan type deleted successfully!";
        }
        return "Insurance plan type not found!";
    }
}