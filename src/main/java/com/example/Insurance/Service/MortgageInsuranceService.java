package com.example.Insurance.Service;

import com.example.Insurance.DTO.MortgageInsuranceDTO;
import com.example.Insurance.Model.MortgageInsurance;
import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Model.InsurancePlanType;
import com.example.Insurance.Repository.MortgageInsuranceRepo;
import com.example.Insurance.Repository.InsuranceCategoryRepo;
import com.example.Insurance.Repository.InsurancePlanTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MortgageInsuranceService {

    @Autowired
    private MortgageInsuranceRepo mortgageInsuranceRepo;

    @Autowired
    private InsuranceCategoryRepo insuranceCategoryRepo;

    @Autowired
    private InsurancePlanTypeRepo insurancePlanTypeRepo;

    public List<MortgageInsurance> getAllMortgageInsurances() {
        return mortgageInsuranceRepo.findAll();
    }

    public Optional<MortgageInsurance> getMortgageInsuranceById(Long id) {
        return mortgageInsuranceRepo.findById(id);
    }

    public MortgageInsurance createMortgageInsurance(MortgageInsuranceDTO dto) {
        MortgageInsurance insurance = convertDtoToEntity(dto);
        return mortgageInsuranceRepo.save(insurance);
    }

    public MortgageInsurance updateMortgageInsurance(Long id, MortgageInsuranceDTO dto) {
        MortgageInsurance existingInsurance = mortgageInsuranceRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("MortgageInsurance not found with id: " + id));

        updateEntityFromDto(existingInsurance, dto);
        return mortgageInsuranceRepo.save(existingInsurance);
    }

    public boolean deleteMortgageInsurance(Long id) {
        if (mortgageInsuranceRepo.existsById(id)) {
            mortgageInsuranceRepo.deleteById(id);
            return true;
        }
        return false;
    }

    private MortgageInsurance convertDtoToEntity(MortgageInsuranceDTO dto) {
        MortgageInsurance insurance = new MortgageInsurance();
        updateEntityFromDto(insurance, dto);
        return insurance;
    }

    private void updateEntityFromDto(MortgageInsurance insurance, MortgageInsuranceDTO dto) {
        insurance.setPropertyValue(dto.getPropertyValue());
        insurance.setLoanAmount(dto.getLoanAmount());
        insurance.setInterestRate(dto.getInterestRate());
        insurance.setPropertyAddress(dto.getPropertyAddress());
        insurance.setIsActive(dto.getIsActive());

        InsuranceCategory category = insuranceCategoryRepo.findById(dto.getInsuranceCategory())
                .orElseThrow(() -> new RuntimeException("InsuranceCategory not found with id: " + dto.getInsuranceCategory()));
        insurance.setInsuranceCategory(category);

        InsurancePlanType planType = insurancePlanTypeRepo.findById(dto.getInsurancePlanType())
                .orElseThrow(() -> new RuntimeException("InsurancePlanType not found with id: " + dto.getInsurancePlanType()));
        insurance.setInsurancePlanType(planType);
    }
}

