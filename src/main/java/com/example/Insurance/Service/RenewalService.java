package com.example.Insurance.Service;

import com.example.Insurance.Model.Renewal;
import com.example.Insurance.Model.InsurancePolicy;
import com.example.Insurance.Repository.InsurancePolicyRepo;
import com.example.Insurance.Repository.RenewalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenewalService {

    @Autowired
    private RenewalRepository renewalRepository;

    @Autowired
    private InsurancePolicyRepo insurancePolicyRepository;

    public List<Renewal> getAllRenewals() {
        return renewalRepository.findAll();
    }

    public Optional<Renewal> getRenewalById(Long id) {
        return renewalRepository.findById(id);
    }

    public Renewal createRenewal(Renewal renewal) {
        if (renewal.getPolicyId() == null) {
            throw new IllegalArgumentException("Policy ID is required");
        }

        Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById(renewal.getPolicyId());
        if (!policyOptional.isPresent()) {
            throw new RuntimeException("Policy not found with id: " + renewal.getPolicyId());
        }

        renewal.setPolicy(policyOptional.get());
        return renewalRepository.save(renewal);
    }

    public Renewal updateRenewal(Long id, Renewal renewalDetails) {
        Renewal renewal = renewalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Renewal not found with id: " + id));

        renewal.setAuditRenewalDate(renewalDetails.getAuditRenewalDate());
        renewal.setRenewalAmount(renewalDetails.getRenewalAmount());

        if (renewalDetails.getPolicyId() != null && !renewalDetails.getPolicyId().equals(renewal.getPolicyId())) {
            Optional<InsurancePolicy> policyOptional = insurancePolicyRepository.findById(renewalDetails.getPolicyId());
            if (!policyOptional.isPresent()) {
                throw new RuntimeException("Policy not found with id: " + renewalDetails.getPolicyId());
            }
            renewal.setPolicy(policyOptional.get());
            renewal.setPolicyId(renewalDetails.getPolicyId());
        }

        return renewalRepository.save(renewal);
    }

    public void deleteRenewal(Long id) {
        renewalRepository.deleteById(id);
    }
}
