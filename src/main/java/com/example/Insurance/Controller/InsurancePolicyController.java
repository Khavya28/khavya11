package com.example.Insurance.Controller;

import com.example.Insurance.Model.Insurance_Policy;
import com.example.Insurance.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class InsurancePolicyController {
    @Autowired
    private InsurancePolicyService insurancepolicyservice;
    @GetMapping("/policy/{id}")
    public Optional<Object[]> getPolicyDetailsById(@PathVariable("id") int id) {
        InsurancePolicyController insurancePolicyService;
        return insurancepolicyservice.getPolicyDetailsById(id);
    }

}
