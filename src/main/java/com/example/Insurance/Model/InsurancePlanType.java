package com.example.Insurance.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class InsurancePlanType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String planType;
    private BigDecimal premiumAmount;
    private BigDecimal coverageAmount;
    private Integer tenure;
    private BigDecimal liabilityCoverage;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId; // Add this field to associate plan types with categories

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String planType) {
        this.planType = planType;
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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}