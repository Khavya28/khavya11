package com.example.Insurance.Controller;

import com.example.Insurance.DTO.ElectroSecureInsuranceDTO;
import com.example.Insurance.Model.ElectroSecureInsurance;
import com.example.Insurance.Service.ElectroSecureInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/electro-secure-insurance")
public class ElectroSecureInsuranceController {

    @Autowired
    private ElectroSecureInsuranceService electroSecureInsuranceService;

    @PostMapping
    public ResponseEntity<?> createElectroSecureInsurance(@RequestBody ElectroSecureInsuranceDTO dto) {
        try {
            if (dto.getCustomerId() != null) { // Check if customerId is not null
                throw new IllegalArgumentException("The customer ID should not be provided for creation");
            }
            ElectroSecureInsurance createdInsurance = electroSecureInsuranceService.createElectroSecureInsurance(dto);
            return new ResponseEntity<>(createdInsurance, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("An error occurred while creating the insurance", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getElectroSecureInsuranceById(@PathVariable Long id) {
        try {
            return electroSecureInsuranceService.getElectroSecureInsuranceById(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateElectroSecureInsurance(@PathVariable Long id, @RequestBody ElectroSecureInsuranceDTO dto) {
        try {
            ElectroSecureInsurance updatedInsurance = electroSecureInsuranceService.updateElectroSecureInsurance(id, dto);
            return ResponseEntity.ok(updatedInsurance);
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error updating ElectroSecure Insurance");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteElectroSecureInsurance(@PathVariable Long id) {
        try {
            boolean deleted = electroSecureInsuranceService.deleteElectroSecureInsurance(id);
            if (deleted) {
                return ResponseEntity.ok("ElectroSecure Insurance with ID: " + id + " successfully deleted.");
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("ElectroSecure Insurance with ID: " + id + " not found.");
            }
        } catch (Exception e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Error deleting ElectroSecure Insurance");
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
}

