package com.example.Insurance.Service;

import com.example.Insurance.DTO.LifeHealthInsuranceDTO;
import com.example.Insurance.Model.*;
import com.example.Insurance.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class LifeHealthInsuranceService {

    @Autowired
    private LifeHealthInsuranceRepo lifeHealthInsuranceRepo;

    @Autowired
    private InsuranceCategoryRepo insuranceCategoryRepo;

    @Autowired
    private InsurancePlanTypeRepo insurancePlanTypeRepo;

    @Autowired
    private NomineeRepository nomineeRepo;

    @Autowired
    private CustomerRepo customerRepo;

    // Fetch all records
    public List<LifeHealthInsurance> getAllLifeHealthInsurances() {
        return lifeHealthInsuranceRepo.findAll();
    }

    // Fetch a record by ID
    public Optional<LifeHealthInsurance> getLifeHealthInsuranceById(Long id) {
        return lifeHealthInsuranceRepo.findById(id);
    }

    // Create a new record
    public LifeHealthInsurance createLifeHealthInsurance(LifeHealthInsuranceDTO dto) throws IOException {
        LifeHealthInsurance insurance = new LifeHealthInsurance();
        updateEntityFromDto(insurance, dto); // Map DTO to Entity
        return lifeHealthInsuranceRepo.save(insurance);
    }

    // Update an existing record
    public LifeHealthInsurance updateLifeHealthInsurance(Long id, LifeHealthInsuranceDTO dto) throws IOException {
        LifeHealthInsurance existingInsurance = lifeHealthInsuranceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("LifeHealthInsurance not found with id: " + id));
        updateEntityFromDto(existingInsurance, dto); // Map DTO to Entity
        return lifeHealthInsuranceRepo.save(existingInsurance);
    }

    // Delete a record by ID
    public boolean deleteLifeHealthInsurance(Long id) {
        if (lifeHealthInsuranceRepo.existsById(id)) {
            lifeHealthInsuranceRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private void updateEntityFromDto(LifeHealthInsurance insurance, LifeHealthInsuranceDTO dto) throws IOException {
        insurance.setAgeLimit(dto.getAgeLimit());

        if (dto.getMedicalHistoryFile() != null && !dto.getMedicalHistoryFile().isEmpty()) {
            insurance.setMedicalHistoryFileName(dto.getMedicalHistoryFile().getOriginalFilename());
            insurance.setMedicalHistoryFileData(dto.getMedicalHistoryFile().getBytes());
        }
        insurance.setIsActive(dto.getIsActive());

        InsuranceCategory category = insuranceCategoryRepo.findById(dto.getInsuranceCategoryId())
                .orElseThrow(() -> new RuntimeException("InsuranceCategory not found"));
        insurance.setInsuranceCategory(category);

        InsurancePlanType planType = insurancePlanTypeRepo.findById(dto.getInsurancePlanTypeId())
                .orElseThrow(() -> new RuntimeException("InsurancePlanType not found"));
        insurance.setInsurancePlanType(planType);

        if (dto.getNomineeId() != null) {
            Nominee nominee = nomineeRepo.findById(dto.getNomineeId())
                    .orElseThrow(() -> new RuntimeException("Nominee not found"));
            insurance.setNominee(nominee);
        }

        Customer customer = customerRepo.findById(dto.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        insurance.setCustomer(customer);
    }
}

