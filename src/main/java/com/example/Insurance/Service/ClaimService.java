package com.example.Insurance.Service;

import com.example.Insurance.Model.Claim;
import com.example.Insurance.Model.Customer;
import com.example.Insurance.Repository.ClaimRepository;
import com.example.Insurance.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClaimService {
    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private CustomerRepo customerRepository;



    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    @Transactional
    public Claim storeClaim( MultipartFile file1, MultipartFile file2, MultipartFile file3,
                             Long claimAmount, LocalDate auditClaimDate, String reasonForClaim,
                             LocalDate auditSettlementDate, String claimStatus, Long customerId) {
        // Fetch the customer
        Customer customer = customerRepository.findById(Math.toIntExact(customerId))
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Claim claim = new Claim();
        claim.setClaimAmount(claimAmount);
        claim.setAuditClaimDate(auditClaimDate);
        claim.setReasonForClaim(reasonForClaim);
        claim.setAuditSettlementDate(auditSettlementDate);
        claim.setClaimStatus(claimStatus);
        claim.setCustomer(customer);

        try {
            // Store File 1
            claim.setFile1Data(file1.getBytes());
            claim.setFile1Name(file1.getOriginalFilename());
            claim.setFile1Type(file1.getContentType());

            // Store File 2
            claim.setFile2Data(file2.getBytes());
            claim.setFile2Name(file2.getOriginalFilename());
            claim.setFile2Type(file2.getContentType());

            // Store File 3
            claim.setFile3Data(file3.getBytes());
            claim.setFile3Name(file3.getOriginalFilename());
            claim.setFile3Type(file3.getContentType());

        } catch (IOException e) {
            throw new RuntimeException("Error processing claim files", e);
        }

        return claimRepository.save(claim);
    }

    @Transactional
    public Claim saveClaim(Map<String, Object> claimData) {
        Integer customerId = (Integer) claimData.get("customerId");
        if (customerId == null) {
            throw new RuntimeException("Customer ID is required");
        }

        Customer customer = (Customer) customerRepository.findById(Math.toIntExact(Long.valueOf(customerId)))
                .orElseThrow(() -> new RuntimeException("Customer not found with ID: " + customerId));

        Claim claim = new Claim();
        claim.setClaimAmount(Long.valueOf(claimData.get("claimAmount").toString()));
        claim.setAuditClaimDate(LocalDate.parse(claimData.get("auditClaimDate").toString()));
        claim.setReasonForClaim(claimData.get("reasonForClaim").toString());
        claim.setAuditSettlementDate(LocalDate.parse(claimData.get("auditSettlementDate").toString()));
        claim.setClaimStatus(claimData.get("claimStatus").toString());
        claim.setCustomer(customer);

        return claimRepository.save(claim);
    }

    @Transactional
    public Claim updateClaim(Long id, Claim claimDetails) {
        Claim claim = claimRepository.findById(Long.valueOf(String.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Claim not found with id: " + id));

        claim.setClaimAmount(claimDetails.getClaimAmount());
        claim.setAuditClaimDate(claimDetails.getAuditClaimDate());
        claim.setReasonForClaim(claimDetails.getReasonForClaim());
        claim.setAuditSettlementDate(claimDetails.getAuditSettlementDate());
        claim.setClaimStatus(claimDetails.getClaimStatus());
        claim.setCustomer(claimDetails.getCustomer());

        return claimRepository.save(claim);
    }

    @Transactional
    public void deleteClaim(Long id) {
        claimRepository.deleteById(Long.valueOf(String.valueOf(id)));
    }

    public List<Claim> getClaimsByCustomerId(Long customerId) {
        return claimRepository.findByCustomer_Cid(customerId);
    }


}
