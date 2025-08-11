package com.example.Insurance.Service;

import com.example.Insurance.DTO.BusinessInsuranceDTO;
import com.example.Insurance.Model.BusinessInsurance;
import com.example.Insurance.Model.Customer;
import com.example.Insurance.Model.InsuranceCategory;
import com.example.Insurance.Model.InsurancePlanType;
import com.example.Insurance.Repository.BusinessInsuranceRepo;
import com.example.Insurance.Repository.CustomerRepo;
import com.example.Insurance.Repository.InsuranceCategoryRepo;
import com.example.Insurance.Repository.InsurancePlanTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusinessInsuranceService {

    @Autowired
    private BusinessInsuranceRepo businessInsuranceRepository;

    @Autowired
    private CustomerRepo customerRepository;

    @Autowired
    private InsuranceCategoryRepo insuranceCategoryRepository;

    @Autowired
    private InsurancePlanTypeRepo insurancePlanTypeRepository;

    public List<BusinessInsuranceDTO> getAllBusinessInsurances() {
        return businessInsuranceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<BusinessInsuranceDTO> getBusinessInsuranceById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        return businessInsuranceRepository.findById(id)
                .map(this::convertToDTO);
    }

    public BusinessInsuranceDTO createBusinessInsurance(BusinessInsuranceDTO dto) {
        if (dto.getCustomerId() == null || dto.getInsuranceCategoryId() == null || dto.getInsurancePlanTypeId() == null) {
            throw new IllegalArgumentException("Customer ID, Insurance Category ID, and Insurance Plan Type ID must not be null");
        }
        BusinessInsurance businessInsurance = convertToEntity(dto);
        BusinessInsurance savedBusinessInsurance = businessInsuranceRepository.save(businessInsurance);
        return convertToDTO(savedBusinessInsurance);
    }

    public Optional<BusinessInsuranceDTO> updateBusinessInsurance(Long id, BusinessInsuranceDTO dto) {
        if (id == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        if (!businessInsuranceRepository.existsById(id)) {
            return Optional.empty();
        }
        BusinessInsurance businessInsurance = convertToEntity(dto);
        businessInsurance.setId(id);
        BusinessInsurance updatedBusinessInsurance = businessInsuranceRepository.save(businessInsurance);
        return Optional.of(convertToDTO(updatedBusinessInsurance));
    }

    public boolean deleteBusinessInsurance(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("The given id must not be null");
        }
        if (!businessInsuranceRepository.existsById(id)) {
            return false;
        }
        businessInsuranceRepository.deleteById(id);
        return true;
    }

    private BusinessInsuranceDTO convertToDTO(BusinessInsurance businessInsurance) {
        BusinessInsuranceDTO dto = new BusinessInsuranceDTO();
        dto.setId(businessInsurance.getId());
        dto.setInsuranceCategoryId(businessInsurance.getInsuranceCategory().getId());
        dto.setInsurancePlanTypeId(businessInsurance.getInsurancePlanType().getId());
        dto.setCustomerId(businessInsurance.getCustomer().getCid());
        dto.setCategory(businessInsurance.getCategory());
        dto.setSubCategory(businessInsurance.getSubCategory());
        dto.setOccupancy(businessInsurance.getOccupancy());
        dto.setTurnover(businessInsurance.getTurnover());
        dto.setRegistered(businessInsurance.getRegistered());
        dto.setPublicLiability(businessInsurance.isPublicLiability());
        dto.setPublicLiabilityTerritory(businessInsurance.getPublicLiabilityTerritory());
        dto.setPublicLiabilityJurisdiction(businessInsurance.getPublicLiabilityJurisdiction());
        dto.setProductLiability(businessInsurance.isProductLiability());
        dto.setProductLiabilityTerritory(businessInsurance.getProductLiabilityTerritory());
        dto.setProductLiabilityJurisdiction(businessInsurance.getProductLiabilityJurisdiction());
        dto.setLimitLiability(businessInsurance.getLimitLiability());
        dto.setLocations(businessInsurance.getLocations());
        dto.setActive(businessInsurance.getActive());
        return dto;
    }

    private BusinessInsurance convertToEntity(BusinessInsuranceDTO dto) {
        BusinessInsurance businessInsurance = new BusinessInsurance();
        businessInsurance.setId(dto.getId());

        Customer customer = customerRepository.findById(dto.getCustomerId().intValue())
                .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        businessInsurance.setCustomer(customer);

        InsuranceCategory category = insuranceCategoryRepository.findById(dto.getInsuranceCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("InsuranceCategory not found"));
        businessInsurance.setInsuranceCategory(category);

        InsurancePlanType planType = insurancePlanTypeRepository.findById(dto.getInsurancePlanTypeId())
                .orElseThrow(() -> new IllegalArgumentException("InsurancePlanType not found"));
        businessInsurance.setInsurancePlanType(planType);

        businessInsurance.setCategory(dto.getCategory());
        businessInsurance.setSubCategory(dto.getSubCategory());
        businessInsurance.setOccupancy(dto.getOccupancy());
        businessInsurance.setTurnover(dto.getTurnover());
        businessInsurance.setRegistered(dto.getRegistered());
        businessInsurance.setPublicLiability(dto.isPublicLiability());
        businessInsurance.setPublicLiabilityTerritory(dto.getPublicLiabilityTerritory());
        businessInsurance.setPublicLiabilityJurisdiction(dto.getPublicLiabilityJurisdiction());
        businessInsurance.setProductLiability(dto.isProductLiability());
        businessInsurance.setProductLiabilityTerritory(dto.getProductLiabilityTerritory());
        businessInsurance.setProductLiabilityJurisdiction(dto.getProductLiabilityJurisdiction());
        businessInsurance.setLimitLiability(dto.getLimitLiability());
        businessInsurance.setLocations(dto.getLocations());
        businessInsurance.setActive(dto.isActive());
        return businessInsurance;
    }
}

