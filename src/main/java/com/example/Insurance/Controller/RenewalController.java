package com.example.Insurance.Controller;

import com.example.Insurance.Model.Renewal;
import com.example.Insurance.Service.RenewalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/renewals")
@CrossOrigin(origins = "*")
public class RenewalController {

    @Autowired
    private RenewalService renewalService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Renewal>> getAllRenewals() {
        return ResponseEntity.ok(renewalService.getAllRenewals());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Renewal> getRenewalById(@PathVariable Long id) {
        return renewalService.getRenewalById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createRenewal(@RequestBody Renewal renewal) {
        try {
            Renewal createdRenewal = renewalService.createRenewal(renewal);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdRenewal);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateRenewal(@PathVariable Long id, @RequestBody Renewal renewalDetails) {
        try {
            Renewal updatedRenewal = renewalService.updateRenewal(id, renewalDetails);
            return ResponseEntity.ok(updatedRenewal);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRenewal(@PathVariable Long id) {
        renewalService.deleteRenewal(id);
        return ResponseEntity.ok().build();
    }
}

