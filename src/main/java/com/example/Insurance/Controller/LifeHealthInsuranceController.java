package com.example.Insurance.Controller;

import com.example.Insurance.DTO.LifeHealthInsuranceDTO;
import com.example.Insurance.Model.LifeHealthInsurance;
import com.example.Insurance.Service.LifeHealthInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/life-health-insurance")
public class LifeHealthInsuranceController {

    @Autowired
    private LifeHealthInsuranceService lifeHealthInsuranceService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createLifeHealthInsurance(
            @RequestParam("ageLimit") Integer ageLimit,
            @RequestParam("medicalHistory") MultipartFile medicalHistory,
            @RequestParam("isActive") Boolean isActive,
            @RequestParam("insuranceCategoryId") Integer insuranceCategoryId,
            @RequestParam("insurancePlanTypeId") Integer insurancePlanTypeId,
            @RequestParam(value = "nomineeId", required = false) Long nomineeId,
            @RequestParam("customerId") Integer customerId) {
        try {
            LifeHealthInsuranceDTO dto = new LifeHealthInsuranceDTO();
            dto.setAgeLimit(ageLimit);
            dto.setMedicalHistoryFile(medicalHistory);
            dto.setIsActive(isActive);
            dto.setInsuranceCategoryId(insuranceCategoryId);
            dto.setInsurancePlanTypeId(insurancePlanTypeId);
            dto.setNomineeId(nomineeId);
            dto.setCustomerId(customerId);

            LifeHealthInsurance createdInsurance = lifeHealthInsuranceService.createLifeHealthInsurance(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdInsurance);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error creating Life Health Insurance");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLifeHealthInsuranceById(@PathVariable Long id) {
        try {
            return lifeHealthInsuranceService.getLifeHealthInsuranceById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error retrieving Life Health Insurance");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateLifeHealthInsurance(
            @PathVariable Long id,
            @RequestParam(value = "ageLimit", required = false) Integer ageLimit,
            @RequestParam(value = "medicalHistory", required = false) MultipartFile medicalHistory,
            @RequestParam(value = "isActive", required = false) Boolean isActive,
            @RequestParam(value = "insuranceCategoryId", required = false) Integer insuranceCategoryId,
            @RequestParam(value = "insurancePlanTypeId", required = false) Integer insurancePlanTypeId,
            @RequestParam(value = "nomineeId", required = false) Long nomineeId,
            @RequestParam(value = "customerId", required = false) Integer customerId) {
        try {
            LifeHealthInsuranceDTO dto = new LifeHealthInsuranceDTO();
            dto.setAgeLimit(ageLimit);
            dto.setMedicalHistoryFile(medicalHistory);
            dto.setIsActive(isActive);
            dto.setInsuranceCategoryId(insuranceCategoryId);
            dto.setInsurancePlanTypeId(insurancePlanTypeId);
            dto.setNomineeId(nomineeId);
            dto.setCustomerId(customerId);

            LifeHealthInsurance updatedInsurance = lifeHealthInsuranceService.updateLifeHealthInsurance(id, dto);
            return ResponseEntity.ok(updatedInsurance);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error updating Life Health Insurance");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLifeHealthInsurance(@PathVariable Long id) {
        try {
            boolean deleted = lifeHealthInsuranceService.deleteLifeHealthInsurance(id);
            if (deleted) {
                return ResponseEntity.ok("Life Health Insurance with ID: " + id + " successfully deleted.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Life Health Insurance with ID: " + id + " not found.");
            }
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error deleting Life Health Insurance");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}

