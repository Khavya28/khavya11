package com.example.Insurance.Controller;

import com.example.Insurance.Model.Nominee;
import com.example.Insurance.Service.NomineeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/nominees")
@CrossOrigin(origins = "http://localhost:5173")
public class NomineeController {

    @Autowired
    private NomineeService nomineeService;

    @GetMapping
    public List<Nominee> getAllNominees() {
        return nomineeService.getAllNominees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nominee> getNomineeById(@PathVariable Long id) {
        return nomineeService.getNomineeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createNominee(@RequestBody Map<String, Object> nomineeData) {
        try {
            Nominee savedNominee = nomineeService.createNominee(nomineeData);
            return ResponseEntity.ok(savedNominee);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating nominee: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Nominee> updateNominee(@PathVariable Long id, @RequestBody Nominee nomineeDetails) {
        Nominee updatedNominee = nomineeService.updateNominee(id, nomineeDetails);
        return ResponseEntity.ok(updatedNominee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNominee(@PathVariable Long id) {
        nomineeService.deleteNominee(id);
        return ResponseEntity.ok().build();
    }
}

