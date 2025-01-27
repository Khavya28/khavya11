package com.example.Insurance.Model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class  Audit {
    @Column(name = "audit_cre_dttm",nullable = false,updatable = false)
    private LocalDateTime auditcredttm;
    @Column(name = "last_modified_dttm",nullable = false)
    private LocalDateTime lastmodifieddttm;
    @PrePersist
    protected void oncreate()
    {
        this.auditcredttm=LocalDateTime.now();
        this.lastmodifieddttm=LocalDateTime.now();
    }
    @PreUpdate
    protected void onupdate()
    {
        this.lastmodifieddttm=LocalDateTime.now();
    }

    public LocalDateTime getAuditcredttm() {
        return auditcredttm;
    }

    public LocalDateTime getLastmodifieddttm() {
        return lastmodifieddttm;
    }
}
