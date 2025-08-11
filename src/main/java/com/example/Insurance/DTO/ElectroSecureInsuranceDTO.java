package com.example.Insurance.DTO;

import java.math.BigDecimal;

public class ElectroSecureInsuranceDTO {
    private Long productId;
    private String productName;
    private String brand;
    private BigDecimal deviceCost;
    private String warrantyPeriod;
    private String serialNumber;
    private Boolean isActive;
    private Integer insuranceCategoryId;
    private Integer insurancePlanTypeId;
    private Integer customerId;

    // Getters and Setters

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public BigDecimal getDeviceCost() {
        return deviceCost;
    }

    public void setDeviceCost(BigDecimal deviceCost) {
        this.deviceCost = deviceCost;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Integer getInsuranceCategoryId() {
        return insuranceCategoryId;
    }

    public void setInsuranceCategoryId(Integer insuranceCategoryId) {
        this.insuranceCategoryId = insuranceCategoryId;
    }

    public Integer getInsurancePlanTypeId() {
        return insurancePlanTypeId;
    }

    public void setInsurancePlanTypeId(Integer insurancePlanTypeId) {
        this.insurancePlanTypeId = insurancePlanTypeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

