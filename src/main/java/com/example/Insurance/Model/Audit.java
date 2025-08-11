package com.example.Insurance.Model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class Audit {
    @CreationTimestamp
    @Column(name = "audit_cre_dttm", nullable = false, updatable = false)
    private LocalDateTime auditCreDttm;

    @UpdateTimestamp
    @Column(name = "last_modified_dttm", nullable = false)
    private LocalDateTime lastModifiedDttm;

    @PrePersist
    protected void onCreate() {
        auditCreDttm = LocalDateTime.now();
        lastModifiedDttm = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        lastModifiedDttm = LocalDateTime.now();
    }

    public LocalDateTime getAuditCreDttm() {
        return auditCreDttm;
    }

    public LocalDateTime getLastModifiedDttm() {
        return lastModifiedDttm;
    }
}

