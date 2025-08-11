package com.example.Insurance.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "life_health_insurance")
public class LifeHealthInsurance extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "life_health_id")
    private Long lifeHealthId;

    @Column(name = "age_limit")
    private Integer ageLimit;

    @Column(name = "medical_history_file_name")
    private String medicalHistoryFileName;

    @Lob
    @Column(name = "medical_history", columnDefinition = "LONGBLOB")
    private byte[] medicalHistoryFileData;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "insurance_category_id")
    private InsuranceCategory insuranceCategory;

    @ManyToOne
    @JoinColumn(name = "insurance_plan_type_id")
    private InsurancePlanType insurancePlanType;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nominee_id")
    private Nominee nominee;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    // Getters and Setters

    public Long getLifeHealthId() {
        return lifeHealthId;
    }

    public void setLifeHealthId(Long lifeHealthId) {
        this.lifeHealthId = lifeHealthId;
    }

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public String getMedicalHistoryFileName() {
        return medicalHistoryFileName;
    }

    public void setMedicalHistoryFileName(String medicalHistoryFileName) {
        this.medicalHistoryFileName = medicalHistoryFileName;
    }

    public byte[] getMedicalHistoryFileData() {
        return medicalHistoryFileData;
    }

    public void setMedicalHistoryFileData(byte[] medicalHistoryFileData) {
        this.medicalHistoryFileData = medicalHistoryFileData;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
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

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

