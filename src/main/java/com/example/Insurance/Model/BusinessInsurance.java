package com.example.Insurance.Model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "business_insurance")
public class BusinessInsurance extends Audit {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "insurance_category_id", nullable = false)
        private InsuranceCategory insuranceCategory;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "insurance_plan_type_id", nullable = false)
        private InsurancePlanType insurancePlanType;

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "customer_id", nullable = false)
        private Customer customer;

        private String category; // Industry Category
        private String subCategory; // Industry Sub Category
        private String occupancy; // Type of Occupancy
        private String turnover; // Company Turnover
        private String registered;

        private boolean publicLiability; // Public Liability selected
        private String publicLiabilityTerritory;
        private String publicLiabilityJurisdiction;

        private boolean productLiability; // Product Liability selected
        private String productLiabilityTerritory;
        private String productLiabilityJurisdiction;

        private String limitLiability; // Limit of Liability
        private int locations; // Number of business locations
        private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(String occupancy) {
        this.occupancy = occupancy;
    }

    public String getTurnover() {
        return turnover;
    }

    public void setTurnover(String turnover) {
        this.turnover = turnover;
    }

    public String getRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public boolean isPublicLiability() {
        return publicLiability;
    }

    public void setPublicLiability(boolean publicLiability) {
        this.publicLiability = publicLiability;
    }

    public String getPublicLiabilityTerritory() {
        return publicLiabilityTerritory;
    }

    public void setPublicLiabilityTerritory(String publicLiabilityTerritory) {
        this.publicLiabilityTerritory = publicLiabilityTerritory;
    }

    public String getPublicLiabilityJurisdiction() {
        return publicLiabilityJurisdiction;
    }

    public void setPublicLiabilityJurisdiction(String publicLiabilityJurisdiction) {
        this.publicLiabilityJurisdiction = publicLiabilityJurisdiction;
    }

    public boolean isProductLiability() {
        return productLiability;
    }

    public void setProductLiability(boolean productLiability) {
        this.productLiability = productLiability;
    }

    public String getProductLiabilityTerritory() {
        return productLiabilityTerritory;
    }

    public void setProductLiabilityTerritory(String productLiabilityTerritory) {
        this.productLiabilityTerritory = productLiabilityTerritory;
    }

    public String getProductLiabilityJurisdiction() {
        return productLiabilityJurisdiction;
    }

    public void setProductLiabilityJurisdiction(String productLiabilityJurisdiction) {
        this.productLiabilityJurisdiction = productLiabilityJurisdiction;
    }

    public String getLimitLiability() {
        return limitLiability;
    }

    public void setLimitLiability(String limitLiability) {
        this.limitLiability = limitLiability;
    }

    public int getLocations() {
        return locations;
    }

    public void setLocations(int locations) {
        this.locations = locations;
    }

    // Getters and Setters
    }
