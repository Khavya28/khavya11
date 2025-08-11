package com.example.Insurance.DTO;

import java.math.BigDecimal;

public class MortgageInsuranceDTO {
    private BigDecimal propertyValue;
    private BigDecimal loanAmount;
    private BigDecimal interestRate;
    private String propertyAddress;
    private Boolean isActive;
    private Integer insuranceCategory;
    private Integer insurancePlanType;

    // Getters and setters
    public BigDecimal getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(BigDecimal propertyValue) {
        this.propertyValue = propertyValue;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getInsuranceCategory() {
        return insuranceCategory;
    }

    public void setInsuranceCategory(Integer insuranceCategory) {
        this.insuranceCategory = insuranceCategory;
    }

    public Integer getInsurancePlanType() {
        return insurancePlanType;
    }

    public void setInsurancePlanType(Integer insurancePlanType) {
        this.insurancePlanType = insurancePlanType;
    }
}

