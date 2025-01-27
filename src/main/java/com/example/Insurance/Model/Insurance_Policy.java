package com.example.Insurance.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

@Entity
public class Insurance_Policy extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "insurance_plan_type_id")
    private InsurancePlanType insurancePlanType;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }

    @ManyToOne
    @JoinColumn(name = "nominee_id")
    private Nominee nominee;

    private String policyName;
    private String policyholdername;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getPolicyholdername() {
        return policyholdername;
    }

    public void setPolicyholdername(String policyholdername) {
        this.policyholdername = policyholdername;
    }

    public Insurance_Policy(int id, InsurancePlanType insurancePlanType, Customer customer, Nominee nominee, String policyName, String policyholdername) {
        this.id = id;
        this.insurancePlanType = insurancePlanType;
        this.customer = customer;
        this.nominee = nominee;
        this.policyName = policyName;
        this.policyholdername = policyholdername;
    }

    public Insurance_Policy() {
    }
}
