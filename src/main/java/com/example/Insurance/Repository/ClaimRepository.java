package com.example.Insurance.Repository;

import com.example.Insurance.Model.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    List<Claim> findByCustomer_Cid(Long cid);

}