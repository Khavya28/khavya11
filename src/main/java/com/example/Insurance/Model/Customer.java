package com.example.Insurance.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="customer")
@Setter
@Getter
public class Customer extends Audit {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Customer_id")
        private int cid;
        @Column(name = "Name")
        private String name;
        @Column(name = "Dob")
        private String dob;
        @Column(name = "Phone",unique = true,nullable = false)
        private String phone;
        @Column(name = "Email",unique = true)
        private String email;
        @Column(name = "Address")
        private String address;
        @Column(name = "Identity_proof")
        private String idenproof;

        @OneToMany(mappedBy = "customer")
        private List<Insurance_Policy> insurance_policy;
        @OneToOne(mappedBy = "customer",cascade = CascadeType.ALL)
        private Login login;

    public Customer(int cid, String name, String dob, String phone, String email, String address, String idenproof, List<Insurance_Policy> insurance_policy, Login login) {
        this.cid = cid;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.idenproof = idenproof;
        this.insurance_policy = insurance_policy;
        this.login = login;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdenproof() {
        return idenproof;
    }

    public void setIdenproof(String idenproof) {
        this.idenproof = idenproof;
    }

    public List<Insurance_Policy> getInsurance_policy() {
        return insurance_policy;
    }

    public void setInsurance_policy(List<Insurance_Policy> insurance_policy) {
        this.insurance_policy = insurance_policy;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
}
