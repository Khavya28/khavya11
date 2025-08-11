package com.example.Insurance.Controller;

import com.example.Insurance.DTO.InsurancePolicyDTO;
import com.example.Insurance.Model.Customer;
import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Model.InsurancePolicy;
import com.example.Insurance.Service.CustomerService;
import com.example.Insurance.Service.InsuranceCategoryService;
import com.example.Insurance.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/policy")
public class InsurancePolicyController {
    @Autowired
    private InsurancePolicyService insurancePolicyService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private InsuranceCategoryService insuranceCategoryService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getPolicyDetailsById(@PathVariable("id") int id) {
        Optional<InsurancePolicy> policy = insurancePolicyService.getPolicyById(id);
        return policy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllPolicies() {
        List<InsurancePolicy> policies = insurancePolicyService.getAllPolicies();
        return ResponseEntity.ok(policies);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPolicy(@RequestBody Map<String, Object> requestData) {
        try {
            String policyName = (String) requestData.get("policyName");
            String policyholderName = (String) requestData.get("policyholdername");
            Integer categoryId = (Integer) requestData.get("insurance_category_id");
            Integer customerId = (Integer) requestData.get("customer_id");

            if (policyName == null || policyholderName == null || categoryId == null || customerId == null) {
                return ResponseEntity.badRequest().body("Missing required fields");
            }

            InsurancePolicy policy = new InsurancePolicy();
            policy.setPolicyName(policyName);
            policy.setPolicyholdername(policyholderName);

            Customer customer = customerService.getCustomerById(customerId).orElse(null);
            if (customer == null) {
                return ResponseEntity.badRequest().body("Customer not found");
            }
            policy.setCustomer(customer);

            InsuranceCategory category = insuranceCategoryService.getCategoryById(categoryId);
            if (category == null) {
                return ResponseEntity.badRequest().body("Insurance category not found");
            }
            policy.setInsuranceCategory(category);

            InsurancePolicy savedPolicy = insurancePolicyService.createPolicy(policy);
            return ResponseEntity.ok(savedPolicy);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating policy: " + e.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updatePolicy(@PathVariable int id, @RequestBody InsurancePolicy policyDetails) {
        Optional<InsurancePolicy> updatedPolicy = insurancePolicyService.updatePolicy(id, policyDetails);
        return updatedPolicy.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePolicy(@PathVariable int id) {
        boolean deleted = insurancePolicyService.deletePolicy(id);
        if (deleted) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(404).body("Policy not found");
        }
    }
}