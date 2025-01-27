package com.example.Insurance.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.math.BigDecimal;

    @Entity
    public class InsurancePlanType {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @ManyToOne
        @JoinColumn(name = "insurance_category_id", nullable = false)
        private InsuranceCategory insuranceCategory;

        private String planType;  // e.g., 'Normal', 'Premium', 'PremiumSafe'
        private BigDecimal premiumAmount;
        private BigDecimal coverageAmount;
        private Integer tenure;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public InsuranceCategory getInsuranceCategory() {
            return insuranceCategory;
        }

        public void setInsuranceCategory(InsuranceCategory insuranceCategory) {
            this.insuranceCategory = insuranceCategory;
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
    }

