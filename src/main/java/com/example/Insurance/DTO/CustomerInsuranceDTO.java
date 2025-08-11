package com.example.Insurance.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomerInsuranceDTO {
    private Long id;
    private String insuranceType;
    private String policyDetails;
    private BigDecimal premiumAmount;
    private BigDecimal coverageAmount;
    private Integer tenure;
    private BigDecimal liabilityCoverage;
    private String categoryName;
    private LocalDate startDate;
    private Boolean isActive;

    public CustomerInsuranceDTO(Long id, String insuranceType, String policyDetails, BigDecimal premiumAmount,
                                BigDecimal coverageAmount, Integer tenure, BigDecimal liabilityCoverage,
                                String categoryName, LocalDate startDate, Boolean isActive) {
        this.id = id;
        this.insuranceType = insuranceType;
        this.policyDetails = policyDetails;
        this.premiumAmount = premiumAmount;
        this.coverageAmount = coverageAmount;
        this.tenure = tenure;
        this.liabilityCoverage = liabilityCoverage;
        this.categoryName = categoryName;
        this.startDate = startDate;
        this.isActive = isActive;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInsuranceType() {
        return insuranceType;
    }

    public void setInsuranceType(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public String getPolicyDetails() {
        return policyDetails;
    }

    public void setPolicyDetails(String policyDetails) {
        this.policyDetails = policyDetails;
    }

    public BigDecimal getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(BigDecimal premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public BigDecimal getCoverageAmount() {
        return coverageAmount;
    }

    public void setCoverageAmount(BigDecimal coverageAmount) {
        this.coverageAmount = coverageAmount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public BigDecimal getLiabilityCoverage() {
        return liabilityCoverage;
    }

    public void setLiabilityCoverage(BigDecimal liabilityCoverage) {
        this.liabilityCoverage = liabilityCoverage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }
}
