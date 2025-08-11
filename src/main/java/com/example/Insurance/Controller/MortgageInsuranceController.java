package com.example.Insurance.Controller;

import com.example.Insurance.DTO.MortgageInsuranceDTO;
import com.example.Insurance.Model.MortgageInsurance;
import com.example.Insurance.Service.MortgageInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mortgage-insurance")
public class MortgageInsuranceController {

    @Autowired
    private MortgageInsuranceService mortgageInsuranceService;

    @GetMapping
    public List<MortgageInsurance> getAllMortgageInsurances() {
        return mortgageInsuranceService.getAllMortgageInsurances();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MortgageInsurance> getMortgageInsuranceById(@PathVariable Long id) {
        return mortgageInsuranceService.getMortgageInsuranceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createMortgageInsurance(@RequestBody MortgageInsuranceDTO dto) {
        try {
            MortgageInsurance createdInsurance = mortgageInsuranceService.createMortgageInsurance(dto);
            return ResponseEntity.ok(createdInsurance);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating mortgage insurance: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMortgageInsurance(@PathVariable Long id, @RequestBody MortgageInsuranceDTO dto) {
        try {
            MortgageInsurance updatedInsurance = mortgageInsuranceService.updateMortgageInsurance(id, dto);
            return ResponseEntity.ok(updatedInsurance);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error updating mortgage insurance: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMortgageInsurance(@PathVariable Long id) {
        boolean deleted = mortgageInsuranceService.deleteMortgageInsurance(id);
        if (deleted) {
            return ResponseEntity.ok("Successfully Deleted Mortgage Insurance with ID: " + id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mortgage Insurance with ID: " + id + " not found");
        }
    }

}

