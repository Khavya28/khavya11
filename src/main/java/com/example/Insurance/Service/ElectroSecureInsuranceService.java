package com.example.Insurance.Service;

import com.example.Insurance.DTO.ElectroSecureInsuranceDTO;
import com.example.Insurance.Model.Customer;
import com.example.Insurance.Model.ElectroSecureInsurance;
import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Model.InsurancePlanType;
import com.example.Insurance.Repository.CustomerRepo;
import com.example.Insurance.Repository.ElectroSecureInsuranceRepo;
import com.example.Insurance.Repository.InsuranceCategoryRepo;
import com.example.Insurance.Repository.InsurancePlanTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ElectroSecureInsuranceService {

    @Autowired
    private ElectroSecureInsuranceRepo repository;

    @Autowired
    private InsuranceCategoryRepo insuranceCategoryRepository;

    @Autowired
    private InsurancePlanTypeRepo insurancePlanTypeRepository;

    @Autowired
    private CustomerRepo customerRepository;

    // Fetch all records
    public List<ElectroSecureInsurance> getAllElectroSecureInsurances() {
        return repository.findAll();
    }

    // Fetch a record by ID
    public Optional<ElectroSecureInsurance> getElectroSecureInsuranceById(Long id) {
        return repository.findById(id);
    }

    public ElectroSecureInsurance createElectroSecureInsurance(ElectroSecureInsuranceDTO dto) {
        ElectroSecureInsurance insurance = new ElectroSecureInsurance();
        insurance.setProductName(dto.getProductName());
        insurance.setBrand(dto.getBrand());
        insurance.setDeviceCost(dto.getDeviceCost());
        insurance.setWarrantyPeriod(LocalDate.parse(dto.getWarrantyPeriod()));
        insurance.setSerialNumber(dto.getSerialNumber());
        insurance.setIsActive(dto.getIsActive());

        // Fetch and set related entities
        InsuranceCategory category = insuranceCategoryRepository.findById(dto.getInsuranceCategoryId())
                .orElseThrow(() -> new RuntimeException("Insurance Category not found"));
        insurance.setInsuranceCategory(category);

        InsurancePlanType planType = insurancePlanTypeRepository.findById(dto.getInsurancePlanTypeId())
                .orElseThrow(() -> new RuntimeException("Insurance Plan Type not found"));
        insurance.setInsurancePlanType(planType);

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        insurance.setCustomer(customer);

        return repository.save(insurance);
    }

    // Update an existing record
    public ElectroSecureInsurance updateElectroSecureInsurance(Long id, ElectroSecureInsuranceDTO dto) {
        ElectroSecureInsurance existingInsurance = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ElectroSecureInsurance not found with id: " + id));
        updateEntityFromDto(existingInsurance, dto); // Map DTO to Entity
        return repository.save(existingInsurance);
    }

    // Delete a record by ID
    public boolean deleteElectroSecureInsurance(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    private void updateEntityFromDto(ElectroSecureInsurance insurance, ElectroSecureInsuranceDTO dto) {
        insurance.setProductName(dto.getProductName());
        insurance.setBrand(dto.getBrand());
        insurance.setDeviceCost(dto.getDeviceCost());

        if (dto.getWarrantyPeriod() != null) {
            try {
                LocalDate warrantyPeriod = LocalDate.parse(dto.getWarrantyPeriod());
                insurance.setWarrantyPeriod(warrantyPeriod);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format for warrantyPeriod. Expected format: yyyy-MM-dd");
            }
        }

        insurance.setSerialNumber(dto.getSerialNumber());
        insurance.setIsActive(dto.getIsActive());

        InsuranceCategory category = insuranceCategoryRepository.findById(dto.getInsuranceCategoryId())
                .orElseThrow(() -> new RuntimeException("InsuranceCategory not found"));
        insurance.setInsuranceCategory(category);

        InsurancePlanType planType = insurancePlanTypeRepository.findById(dto.getInsurancePlanTypeId())
                .orElseThrow(() -> new RuntimeException("InsurancePlanType not found"));
        insurance.setInsurancePlanType(planType);

        Customer customer = customerRepository.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        insurance.setCustomer(customer);
    }
}

