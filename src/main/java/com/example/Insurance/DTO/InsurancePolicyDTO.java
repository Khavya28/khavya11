package com.example.Insurance.DTO;

public class InsurancePolicyDTO {
    private int id;
    private String policyName;
    private String policyholdername;
    private Boolean isActive;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPolicyName() { return policyName; }
    public void setPolicyName(String policyName) { this.policyName = policyName; }

    public String getPolicyholdername() { return policyholdername; }
    public void setPolicyholdername(String policyholdername) { this.policyholdername = policyholdername; }

    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
}