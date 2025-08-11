package com.example.Insurance.Model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Table(name = "customer")
public class Customer extends Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, updatable = false)
    private int cid;

    @Column(name = "Name")
    private String name;

    @Column(name = "Dob")
    private String dob;

    @Column(name = "Phone", unique = true, nullable = false)
    private String phone;

    @Column(name = "Email", unique = true)
    private String email;

    @Column(name = "Password")
    private String password;

    @Column(name = "Address")
    private String address;

    @Column(name = "Identity_proof")
    private String idenproof;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<BusinessInsurance> businessInsurances;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<InsurancePolicy> insurancePolicies;

    public Customer() {

    }

    public long getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDob() { return dob; }
    public void setDob(String dob) { this.dob = dob; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getIdenproof() { return idenproof; }
    public void setIdenproof(String idenproof) { this.idenproof = idenproof; }

    public List<InsurancePolicy> getInsurancePolicies() { return insurancePolicies; }
    public void setInsurancePolicies(List<InsurancePolicy> insurancePolicies) { this.insurancePolicies = insurancePolicies; }

    public Customer(int cid, String name, String dob, String phone, String email, String password, String address, String idenproof, List<BusinessInsurance> businessInsurances, List<InsurancePolicy> insurancePolicies) {
        this.cid = cid;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.address = address;
        this.idenproof = idenproof;
        this.businessInsurances = businessInsurances;
        this.insurancePolicies = insurancePolicies;
    }

    public List<BusinessInsurance> getBusinessInsurances() {
        return businessInsurances;
    }

    public void setBusinessInsurances(List<BusinessInsurance> businessInsurances) {
        this.businessInsurances = businessInsurances;
    }
}