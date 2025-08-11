package com.example.Insurance.Service;

import com.example.Insurance.DTO.InsurancePolicyDTO;
import com.example.Insurance.Model.InsurancePolicy;
import com.example.Insurance.Repository.InsurancePolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsurancePolicyService {
    @Autowired
    private InsurancePolicyRepo insurancePolicyRepo;

    public Optional<InsurancePolicy> getPolicyById(int id) {
        return insurancePolicyRepo.findById(id);
    }

    public List<InsurancePolicy> getAllPolicies() {
        return insurancePolicyRepo.findAll();
    }

    public List<InsurancePolicyDTO> getPoliciesByCustomerId(int customerId) {
        List<InsurancePolicy> policies = insurancePolicyRepo.findByCustomerId(customerId);
        return policies.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    private InsurancePolicyDTO convertToDTO(InsurancePolicy policy) {
        InsurancePolicyDTO dto = new InsurancePolicyDTO();
        dto.setId(policy.getId());
        dto.setPolicyName(policy.getPolicyName());
        dto.setPolicyholdername(policy.getPolicyholdername());
        dto.setIsActive(policy.getIsActive());
        return dto;
    }

    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return insurancePolicyRepo.save(policy);
    }

    public Optional<InsurancePolicy> updatePolicy(int id, InsurancePolicy policyDetails) {
        return insurancePolicyRepo.findById(id).map(existingPolicy -> {
            existingPolicy.setPolicyName(policyDetails.getPolicyName());
            existingPolicy.setPolicyholdername(policyDetails.getPolicyholdername());
            existingPolicy.setIsActive(policyDetails.getIsActive());
            existingPolicy.setCustomer(policyDetails.getCustomer());
            existingPolicy.setInsuranceCategory(policyDetails.getInsuranceCategory());
            return insurancePolicyRepo.save(existingPolicy);
        });
    }

    public boolean deletePolicy(int id) {
        if (insurancePolicyRepo.existsById(id)) {
            insurancePolicyRepo.deleteById(id);
            return true;
        }
        return false;
    }
}