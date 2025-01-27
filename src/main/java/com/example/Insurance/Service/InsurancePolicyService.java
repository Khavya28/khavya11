package com.example.Insurance.Service;

import com.example.Insurance.Model.Insurance_Policy;
import com.example.Insurance.Repository.InsurancePolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsurancePolicyService {
    @Autowired
    private InsurancePolicyRepo insuranceiolicyrepo
    public Insurance_Policy getpolicy(int policyId) {
        return insuranceiolicyrepo.findById(policyId).orElse(null);
    }

    public List<Insurance_Policy> getallpolicy() {
        return insuranceiolicyrepo.findAll();
    }
}
