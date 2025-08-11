package com.example.Insurance.Service;

import com.example.Insurance.Model.LifeHealthInsurance;
import com.example.Insurance.Model.Nominee;
import com.example.Insurance.Repository.LifeHealthInsuranceRepo;
import com.example.Insurance.Repository.NomineeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class NomineeService {

    @Autowired
    private NomineeRepository nomineeRepository;

    @Autowired
    private LifeHealthInsuranceRepo lifeHealthInsuranceRepository;

    public List<Nominee> getAllNominees() {
        return nomineeRepository.findAll();
    }

    public Optional<Nominee> getNomineeById(Long id) {
        return nomineeRepository.findById(id);
    }

    @Transactional
    public Nominee createNominee(Map<String, Object> nomineeData) {
        Nominee nominee = new Nominee();
        nominee.setRelationWithHolder(nomineeData.get("relationWithHolder").toString());
        nominee.setDob(nomineeData.get("dob").toString());
        nominee.setName(nomineeData.get("name").toString());
        nominee.setPhone(nomineeData.get("phone").toString());

        return nomineeRepository.save(nominee);
    }

    @Transactional
    public Nominee updateNominee(Long id, Nominee nomineeDetails) {
        Nominee nominee = nomineeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nominee not found with id: " + id));

        nominee.setRelationWithHolder(nomineeDetails.getRelationWithHolder());
        nominee.setDob(nomineeDetails.getDob());
        nominee.setName(nomineeDetails.getName());
        nominee.setPhone(nomineeDetails.getPhone());

        return nomineeRepository.save(nominee);
    }

    @Transactional
    public void deleteNominee(Long id) {
        nomineeRepository.deleteById(id);
    }
}

