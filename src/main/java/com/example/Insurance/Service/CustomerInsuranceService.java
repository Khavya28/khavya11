package com.example.Insurance.Service;

import com.example.Insurance.DTO.CustomerInsuranceDTO;
import com.example.Insurance.Model.LifeHealthInsurance;
import com.example.Insurance.Model.ElectroSecureInsurance;
import com.example.Insurance.Model.BusinessInsurance;
import com.example.Insurance.Repository.LifeHealthInsuranceRepo;
import com.example.Insurance.Repository.ElectroSecureInsuranceRepo;
import com.example.Insurance.Repository.BusinessInsuranceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerInsuranceService {

    @Autowired
    private LifeHealthInsuranceRepo lifeHealthInsuranceRepo;

    @Autowired
    private ElectroSecureInsuranceRepo electroSecureInsuranceRepo;

    @Autowired
    private BusinessInsuranceRepo businessInsuranceRepo;

    public List<CustomerInsuranceDTO> getAllInsurancesForCustomer(Integer customerId) {
        List<CustomerInsuranceDTO> allInsurances = new ArrayList<>();

        // Fetch LifeHealth insurances
        List<LifeHealthInsurance> lifeHealthInsurances = lifeHealthInsuranceRepo.findByCustomerId(customerId);
        for (LifeHealthInsurance lhi : lifeHealthInsurances) {
            allInsurances.add(new CustomerInsuranceDTO(
                    lhi.getLifeHealthId(),
                    "Life Health",
                    lhi.getInsurancePlanType().getPlanType(),
                    lhi.getInsurancePlanType().getPremiumAmount(),
                    lhi.getInsurancePlanType().getCoverageAmount(),
                    lhi.getInsurancePlanType().getTenure(),
                    lhi.getInsurancePlanType().getLiabilityCoverage(),
                    lhi.getInsuranceCategory().getCategoryName(),
                    lhi.getAuditCreDttm().toLocalDate(),
                    lhi.getIsActive()
            ));
        }

        // Fetch ElectroSecure insurances
        List<ElectroSecureInsurance> electroSecureInsurances = electroSecureInsuranceRepo.findByCustomerId(customerId);
        for (ElectroSecureInsurance esi : electroSecureInsurances) {
            allInsurances.add(new CustomerInsuranceDTO(
                    esi.getProductId(),
                    "ElectroSecure",
                    esi.getInsurancePlanType().getPlanType(),
                    esi.getInsurancePlanType().getPremiumAmount(),
                    esi.getInsurancePlanType().getCoverageAmount(),
                    esi.getInsurancePlanType().getTenure(),
                    esi.getInsurancePlanType().getLiabilityCoverage(),
                    esi.getInsuranceCategory().getCategoryName(),
                    esi.getAuditCreDttm().toLocalDate(),
                    esi.getIsActive()
            ));
        }

        // Fetch Business insurances
        List<BusinessInsurance> businessInsurances = businessInsuranceRepo.findByCustomerId(customerId);
        for (BusinessInsurance bi : businessInsurances) {
            allInsurances.add(new CustomerInsuranceDTO(
                    bi.getId(),
                    "Business",
                    bi.getInsurancePlanType().getPlanType(),
                    bi.getInsurancePlanType().getPremiumAmount(),
                    bi.getInsurancePlanType().getCoverageAmount(),
                    bi.getInsurancePlanType().getTenure(),
                    bi.getInsurancePlanType().getLiabilityCoverage(),
                    bi.getInsuranceCategory().getCategoryName(),
                    bi.getAuditCreDttm().toLocalDate(),
                    bi.getActive()
            ));
        }

        return allInsurances;
    }
}
