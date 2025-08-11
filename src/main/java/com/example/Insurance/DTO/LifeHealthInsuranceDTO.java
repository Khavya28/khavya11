package com.example.Insurance.DTO;

import org.springframework.web.multipart.MultipartFile;

public class LifeHealthInsuranceDTO {
    private Integer ageLimit;
    private MultipartFile medicalHistoryFile;
    private Boolean isActive;
    private Integer insuranceCategoryId;
    private Integer insurancePlanTypeId;
    private Long nomineeId;
    private Integer customerId;

    // Getters and Setters

    public Integer getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(Integer ageLimit) {
        this.ageLimit = ageLimit;
    }

    public MultipartFile getMedicalHistoryFile() {
        return medicalHistoryFile;
    }

    public void setMedicalHistoryFile(MultipartFile medicalHistoryFile) {
        this.medicalHistoryFile = medicalHistoryFile;
    }



    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
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

    public Long getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(Long nomineeId) {
        this.nomineeId = nomineeId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

