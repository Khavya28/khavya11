package com.example.Insurance.Controller;

import com.example.Insurance.DTO.BusinessInsuranceDTO;
import com.example.Insurance.Service.BusinessInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/business-insurance")
@CrossOrigin(origins = "http://localhost:5173")
public class BusinessInsuranceController {

    @Autowired
    private BusinessInsuranceService businessInsuranceService;

    @GetMapping
    public ResponseEntity<List<BusinessInsuranceDTO>> getAllBusinessInsurances() {
        List<BusinessInsuranceDTO> businessInsurances = businessInsuranceService.getAllBusinessInsurances();
        return ResponseEntity.ok(businessInsurances);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BusinessInsuranceDTO> getBusinessInsuranceById(@PathVariable Long id) {
        try {
            return businessInsuranceService.getBusinessInsuranceById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping
    public ResponseEntity<?> createBusinessInsurance(@RequestBody BusinessInsuranceDTO businessInsuranceDTO) {
        try {
            BusinessInsuranceDTO createdBusinessInsurance = businessInsuranceService.createBusinessInsurance(businessInsuranceDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBusinessInsurance);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBusinessInsurance(@PathVariable Long id, @RequestBody BusinessInsuranceDTO businessInsuranceDTO) {
        try {
            Optional<BusinessInsuranceDTO> updatedInsurance = businessInsuranceService.updateBusinessInsurance(id, businessInsuranceDTO);
            return updatedInsurance
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBusinessInsurance(@PathVariable Long id) {
        try {
            if (businessInsuranceService.deleteBusinessInsurance(id)) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

