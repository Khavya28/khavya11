package com.example.Insurance.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

@Entity
@Table(name = "claim")
public class Claim extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "claimId")
    private Long claimId; // ✅ Changed from String to Long

    @Column(name = "claimAmount")
    private Long claimAmount;

    @Column(name = "auditClaimDate", nullable = false)
    private LocalDate auditClaimDate;

    @Column(name = "reasonForClaim", nullable = false)
    private String reasonForClaim;

    @Column(name = "auditSettlementDate", nullable = false)
    private LocalDate auditSettlementDate;

    @Column(name = "claimStatus", nullable = false)
    private String claimStatus;


    @Lob
    @Column(name = "file1_data", columnDefinition = "LONGBLOB")
    private byte[] file1Data;

    private String file1Name;
    private String file1Type;

    @Lob
    @Column(name = "file2_data", columnDefinition = "LONGBLOB")
    private byte[] file2Data;

    private String file2Name;
    private String file2Type;

    @Lob
    @Column(name = "file3_data", columnDefinition = "LONGBLOB")
    private byte[] file3Data;

    private String file3Name;
    private String file3Type;

    @ManyToOne
    @JoinColumn(name = "Customer_id", nullable = false)
    @JsonIgnore  // Prevents infinite recursion
    private Customer customer;

    // Getters and Setters
    public Long getClaimId() {
        return claimId;
    }

    public void setClaimId(Long claimId) {
        this.claimId = claimId;
    }

    public Long getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(Long claimAmount) {
        this.claimAmount = claimAmount;
    }

    public LocalDate getAuditClaimDate() {
        return auditClaimDate;
    }

    public void setAuditClaimDate(LocalDate auditClaimDate) {
        this.auditClaimDate = auditClaimDate;
    }

    public String getReasonForClaim() {
        return reasonForClaim;
    }

    public void setReasonForClaim(String reasonForClaim) {
        this.reasonForClaim = reasonForClaim;
    }

    public LocalDate getAuditSettlementDate() {
        return auditSettlementDate;
    }

    public void setAuditSettlementDate(LocalDate auditSettlementDate) {
        this.auditSettlementDate = auditSettlementDate;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public byte[] getFile1Data() {
        return file1Data;
    }

    public void setFile1Data(byte[] file1Data) {
        this.file1Data = file1Data;
    }

    public String getFile1Name() {
        return file1Name;
    }

    public void setFile1Name(String file1Name) {
        this.file1Name = file1Name;
    }

    public String getFile1Type() {
        return file1Type;
    }

    public void setFile1Type(String file1Type) {
        this.file1Type = file1Type;
    }

    public byte[] getFile2Data() {
        return file2Data;
    }

    public void setFile2Data(byte[] file2Data) {
        this.file2Data = file2Data;
    }

    public String getFile2Name() {
        return file2Name;
    }

    public void setFile2Name(String file2Name) {
        this.file2Name = file2Name;
    }

    public String getFile2Type() {
        return file2Type;
    }

    public void setFile2Type(String file2Type) {
        this.file2Type = file2Type;
    }

    public byte[] getFile3Data() {
        return file3Data;
    }

    public void setFile3Data(byte[] file3Data) {
        this.file3Data = file3Data;
    }

    public String getFile3Name() {
        return file3Name;
    }

    public void setFile3Name(String file3Name) {
        this.file3Name = file3Name;
    }

    public String getFile3Type() {
        return file3Type;
    }

    public void setFile3Type(String file3Type) {
        this.file3Type = file3Type;
    }

}
