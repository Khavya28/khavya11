package com.example.Insurance.Controller;

import com.example.Insurance.Model.Insurance_Policy;
import com.example.Insurance.Service.InsurancePolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InsurancePolicyController {
    @Autowired
    private InsurancePolicyService insurancepolicyservice;
    @GetMapping("/insurance/{policyId}")
    public Insurance_Policy getpolicy(@PathVariable ("policyId") int policyId)
    {
        return insurancepolicyservice.getpolicy(policyId);
    }
    @GetMapping("/allinsurance")
    public List<Insurance_Policy> Getallinsurance()
    {

        return insurancepolicyservice.getallpolicy();
    }

}
