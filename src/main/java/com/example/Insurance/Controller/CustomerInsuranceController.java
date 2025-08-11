package com.example.Insurance.Controller;

import com.example.Insurance.DTO.CustomerInsuranceDTO;
import com.example.Insurance.Service.CustomerInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer-insurance")
public class CustomerInsuranceController {

    @Autowired
    private CustomerInsuranceService customerInsuranceService;

    @GetMapping("/{customerId}")
    public ResponseEntity<?> getAllInsurancesForCustomer(@PathVariable Integer customerId) {
        try {
            List<CustomerInsuranceDTO> insurances = customerInsuranceService.getAllInsurancesForCustomer(customerId);
            if (insurances.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(insurances);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error fetching insurances: " + e.getMessage());
        }
    }
}
