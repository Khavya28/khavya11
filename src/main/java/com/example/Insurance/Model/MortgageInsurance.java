package com.example.Insurance.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "mortgage_insurance")
public class MortgageInsurance extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mortgage_id")
    private Long id;

    @Column(name = "property_value", nullable = false)
    private BigDecimal propertyValue;

    @Column(name = "loan_amount", nullable = false)
    private BigDecimal loanAmount;

    @Column(name = "interest_rate", nullable = false)
    private BigDecimal interestRate;

    @Column(name = "property_address", nullable = false)
    private String propertyAddress;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "insurance_category_id", nullable = false)
    private InsuranceCategory insuranceCategory;

    @ManyToOne
    @JoinColumn(name = "insurance_plan_type_id", nullable = false)
    private InsurancePlanType insurancePlanType;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public InsuranceCategory getInsuranceCategory() {
        return insuranceCategory;
    }

    public void setInsuranceCategory(InsuranceCategory insuranceCategory) {
        this.insuranceCategory = insuranceCategory;
    }

    public InsurancePlanType getInsurancePlanType() {
        return insurancePlanType;
    }

    public void setInsurancePlanType(InsurancePlanType insurancePlanType) {
        this.insurancePlanType = insurancePlanType;
    }

}

