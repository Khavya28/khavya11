package com.example.Insurance.Model;

import jakarta.persistence.*;
import java.util.List;

    @Entity
    public class InsuranceCategory {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String categoryName;  // e.g., 'Business', 'LifeHealth'

        @OneToMany(mappedBy = "insuranceCategory")
        private List<InsurancePlanType> planTypes;

        // Getters and setters
        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public List<InsurancePlanType> getPlanTypes() {
            return planTypes;
        }

        public void setPlanTypes(List<InsurancePlanType> planTypes) {
            this.planTypes = planTypes;
        }
    }




