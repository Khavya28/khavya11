package com.example.Insurance.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "electro_secure_insurance")
public class ElectroSecureInsurance extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "device_cost", nullable = false)
    private BigDecimal deviceCost;

    @Column(name = "warranty_period", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate warrantyPeriod;

    @Column(name = "serial_number", nullable = false)
    private String serialNumber;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "insurance_category_id", nullable = false)
    private InsuranceCategory insuranceCategory;

    @ManyToOne
    @JoinColumn(name = "insurance_plan_type_id", nullable = false)
    private InsurancePlanType insurancePlanType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

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

    public LocalDate getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(LocalDate warrantyPeriod) {
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
}

