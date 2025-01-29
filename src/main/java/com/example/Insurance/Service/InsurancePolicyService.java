package com.example.Insurance.Service;

import com.example.Insurance.Model.Insurance_Policy;
import com.example.Insurance.Repository.InsurancePolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsurancePolicyService {
    @Autowired
    private InsurancePolicyRepo insuranceiolicyrepo;
    public Optional<Object[]> getPolicyDetailsById(int id) {
        return insuranceiolicyrepo.findPolicyWithDetailsById(id);
    }
}
