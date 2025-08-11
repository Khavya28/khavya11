package com.example.Insurance.Controller;

import com.example.Insurance.Model.Claim;
import com.example.Insurance.Service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @GetMapping("/customer/{cid}")
    public ResponseEntity<List<Claim>> getClaimsByCustomerId(@PathVariable Long cid) {
        List<Claim> claims = claimService.getClaimsByCustomerId(cid);
        if (claims.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
        }
        return ResponseEntity.ok(claims);
    }




    @PostMapping("/uploadClaims")
    public UploadFileResponse uploadClaims(
            @RequestParam("file1") MultipartFile file1,
            @RequestParam("file2") MultipartFile file2,
            @RequestParam("file3") MultipartFile file3,
            @RequestParam("claimAmount") Long claimAmount,
            @RequestParam("auditClaimDate") LocalDate auditClaimDate,
            @RequestParam("reasonForClaim") String reasonForClaim,
            @RequestParam("auditSettlementDate") LocalDate auditSettlementDate,
            @RequestParam("claimStatus") String claimStatus,
            @RequestParam("cid") Long cid) {

        Claim claim = claimService.storeClaim(file1, file2, file3, claimAmount, auditClaimDate, reasonForClaim,
                auditSettlementDate, claimStatus, cid);

        return new UploadFileResponse(
                claim.getClaimId(),
                "Files stored successfully!",
                claimAmount, auditClaimDate, reasonForClaim, auditSettlementDate, claimStatus, cid);
    }

}