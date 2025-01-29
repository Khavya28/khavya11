package com.example.Insurance.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.*;

@Entity
public class Claim extends Audit {
    @Id
    @ManyToOne
    @JoinColumn(name = "insurance_policy_id")
    private Insurance_Policy insurancePolicy;

    private String claimDescription;
    private double claimAmount;

    // New fields
    private String status;  // e.g., Pending, Approved, Rejected
    private String supportingDocuments;  // Store file paths or document names

    // Getters and Setters
    public Insurance_Policy getInsurancePolicy() {
        return insurancePolicy;
    }

    public void setInsurancePolicy(Insurance_Policy insurancePolicy) {
        this.insurancePolicy = insurancePolicy;
    }

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(String supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    // Constructor
    public Claim() {
        super();  // Calls the constructor of Audit class
    }

    public Claim(Insurance_Policy insurancePolicy, String claimDescription, double claimAmount, String status, String supportingDocuments) {
        super();
        this.insurancePolicy = insurancePolicy;
        this.claimDescription = claimDescription;
        this.claimAmount = claimAmount;
        this.status = status;
        this.supportingDocuments = supportingDocuments;
    }
}
