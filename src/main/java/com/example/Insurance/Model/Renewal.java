package com.example.Insurance.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "renewal")
public class Renewal extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "renewal_id")
    private Long renewalId;

    @Column(name = "audit_renewal_date", nullable = false)
    private LocalDate auditRenewalDate;

    @Column(name = "renewal_amount", nullable = false)
    private Double renewalAmount;

    @Column(name = "policy_id", nullable = false)
    private Integer policyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "policy_id", insertable = false, updatable = false)
    @JsonBackReference("policy-renewals")
    private InsurancePolicy policy;

    // Getters and setters

    public Long getRenewalId() {
        return renewalId;
    }

    public void setRenewalId(Long renewalId) {
        this.renewalId = renewalId;
    }

    public LocalDate getAuditRenewalDate() {
        return auditRenewalDate;
    }

    public void setAuditRenewalDate(LocalDate auditRenewalDate) {
        this.auditRenewalDate = auditRenewalDate;
    }

    public Double getRenewalAmount() {
        return renewalAmount;
    }

    public void setRenewalAmount(Double renewalAmount) {
        this.renewalAmount = renewalAmount;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public InsurancePolicy getPolicy() {
        return policy;
    }

    public void setPolicy(InsurancePolicy policy) {
        this.policy = policy;
    }
}
