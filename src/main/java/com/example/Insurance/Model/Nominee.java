package com.example.Insurance.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nominee")
public class Nominee extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nomineeId;

    private String relationWithHolder;
    private String dob;
    private String name;
    private String phone;

    @OneToMany(mappedBy = "nominee", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<LifeHealthInsurance> lifeHealthInsurances = new ArrayList<>();

    // Getters and setters

    public Long getNomineeId() {
        return nomineeId;
    }

    public void setNomineeId(Long nomineeId) {
        this.nomineeId = nomineeId;
    }

    public String getRelationWithHolder() {
        return relationWithHolder;
    }

    public void setRelationWithHolder(String relationWithHolder) {
        this.relationWithHolder = relationWithHolder;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<LifeHealthInsurance> getLifeHealthInsurances() {
        return lifeHealthInsurances;
    }

    public void setLifeHealthInsurances(List<LifeHealthInsurance> lifeHealthInsurances) {
        this.lifeHealthInsurances = lifeHealthInsurances;
    }
}

