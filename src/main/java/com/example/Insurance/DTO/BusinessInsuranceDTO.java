package com.example.Insurance.DTO;

public class BusinessInsuranceDTO {
        private Long id;
        private Long insuranceCategoryId;
        private Long insurancePlanTypeId;
        private Long customerId;
        private String category;
        private String subCategory;
        private String occupancy;
        private String turnover;
        private String registered;
        private boolean publicLiability;
        private String publicLiabilityTerritory;
        private String publicLiabilityJurisdiction;
        private boolean productLiability;
        private String productLiabilityTerritory;
        private String productLiabilityJurisdiction;
        private String limitLiability;
        private int locations;
        private boolean isActive;

    public BusinessInsuranceDTO() {}

    public BusinessInsuranceDTO(Long id, Long insuranceCategoryId, Long insurancePlanTypeId, Long customerId, String category, String subCategory, String occupancy, String turnover, String registered, boolean publicLiability, String publicLiabilityTerritory, String publicLiabilityJurisdiction, boolean productLiability, String productLiabilityTerritory, String productLiabilityJurisdiction, String limitLiability, int locations, boolean isActive) {
        this.id = id;
        this.insuranceCategoryId = insuranceCategoryId;
        this.insurancePlanTypeId = insurancePlanTypeId;
        this.customerId = customerId;
        this.category = category;
        this.subCategory = subCategory;
        this.occupancy = occupancy;
        this.turnover = turnover;
        this.registered = registered;
        this.publicLiability = publicLiability;
        this.publicLiabilityTerritory = publicLiabilityTerritory;
        this.publicLiabilityJurisdiction = publicLiabilityJurisdiction;
        this.productLiability = productLiability;
        this.productLiabilityTerritory = productLiabilityTerritory;
        this.productLiabilityJurisdiction = productLiabilityJurisdiction;
        this.limitLiability = limitLiability;
        this.locations = locations;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getInsuranceCategoryId() {
        return Math.toIntExact(insuranceCategoryId);
    }

    public void setInsuranceCategoryId(Long insuranceCategoryId) {
        this.insuranceCategoryId = insuranceCategoryId;
    }

    public Integer getInsurancePlanTypeId() {
        return Math.toIntExact(insurancePlanTypeId);
    }

    public void setInsurancePlanTypeId(Long insurancePlanTypeId) {
        this.insurancePlanTypeId = insurancePlanTypeId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}



