package com.example.Insurance.Controller;

import com.example.Insurance.Model.Customer;
import com.example.Insurance.Model.InsurancePolicy;
import com.example.Insurance.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:5173") // Explicitly allow the React frontend
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(consumes = "multipart/form-data")
    public ResponseEntity<?> createCustomer(
            @RequestParam("name") String name,
            @RequestParam("dobYear") String dobYear,
            @RequestParam("dobMonth") String dobMonth,
            @RequestParam("dobDay") String dobDay,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("confirmPassword") String confirmPassword,
            @RequestParam("address") String address,
            @RequestParam("idenproof") MultipartFile idenproof
    ) {
        try {
            // Combine DOB parts into a single string
            String dob = dobYear + "-" + dobMonth + "-" + dobDay;

            // Validate password match
            if (!password.equals(confirmPassword)) {
                return ResponseEntity.badRequest().body("Passwords do not match.");
            }

            // Create a new customer object
            Customer customer = new Customer();
            customer.setName(name);
            customer.setDob(dob);
            customer.setPhone(phone);
            customer.setEmail(email);
            customer.setPassword(password);
            customer.setAddress(address);

            // Save the uploaded file and store its path
            if (!idenproof.isEmpty()) {
                String filePath = "uploads/" + idenproof.getOriginalFilename(); // Adjust path as needed
                customer.setIdenproof(filePath); // Store file path in the database
                // Save the file to the server (you can use a library like Apache Commons IO)
                // Files.copy(idenproof.getInputStream(), Paths.get(filePath), StandardCopyOption.REPLACE_EXISTING);
            }

            // Save the customer
            String result = customerService.saveCustomer(customer);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error adding customer.");
        }
    }

    // Other methods...

    @PostMapping("/verify-password")
    public ResponseEntity<Map<String, Boolean>> verifyPassword(@RequestBody Map<String, String> request) {
        try {
            int customerId = Integer.parseInt(request.get("customerId"));
            String password = request.get("password");
            boolean isValid = customerService.verifyPassword(customerId, password);
            return ResponseEntity.ok(Collections.singletonMap("success", isValid));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("success", false));
        }
    }

    @PutMapping("/{id}/update-password")
    public ResponseEntity<String> updatePassword(@PathVariable int id, @RequestBody Map<String, String> request) {
        try {
            String newPassword = request.get("password");
            String result = customerService.updatePassword(id, newPassword);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating password.");
        }
    }
    @GetMapping("/login")
    public ResponseEntity<?> loginGet() {
        return ResponseEntity.badRequest().body("Please use POST method for login");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomerDetails(@PathVariable int id) {
        return customerService.getCustomerById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/allcustomerdetails")
    public ResponseEntity<?> getAllCustomerDetails() {
        try {
            List<Customer> customers = customerService.getAllCustomers();
            if (customers.isEmpty()) {
                return ResponseEntity.noContent().build(); // Return 204 No Content if no customers exist
            }
            return ResponseEntity.ok(customers); // Return 200 OK with the list of customers
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching customer details.");
        }
    }
    // Update customer details
    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomerDetails(
            @PathVariable int id,
            @RequestBody Customer updatedCustomer) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updatedCustomer));
    }


    @GetMapping("/{id}/policies")
    public ResponseEntity<?> getCustomerPolicies(@PathVariable int id) {
        try {
            Optional<Customer> customer = customerService.getCustomerById(id);
            if (customer.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            List<InsurancePolicy> policies = customerService.getPoliciesByCustomerId(id);
            return ResponseEntity.ok(policies);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("An error occurred while fetching policies: " + e.getMessage());
        }
    }

    @PostMapping(value = "/login", consumes = "application/json")
    public ResponseEntity<?> login(@RequestBody Customer customer) {
        System.out.println("Received login request for email: " + customer.getEmail());
        Optional<?> foundCustomer = customerService.login(customer.getEmail(), customer.getPassword());

        if (foundCustomer.isPresent()) {
            Customer loggedInCustomer = (Customer) foundCustomer.get();  // Cast to Customer
            System.out.println("Login successful for email: " + customer.getEmail());

            Map<String, Object> response = new HashMap<>();
            response.put("success", true);
            response.put("customerId", loggedInCustomer.getCid()); // ✅ Return customerId
            response.put("message", "Login successful");

            return ResponseEntity.ok(response);
        } else {
            System.out.println("Invalid email or password for email: " + customer.getEmail());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("success", false, "message", "Invalid email or password"));
        }
    }


    @DeleteMapping("/{cid}")
    public ResponseEntity<?> deleteCustomer(@PathVariable int cid) {
        return ResponseEntity.ok(customerService.deleteCustomer(cid));
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<Customer> getCustomerByEmail(@PathVariable String email) {
        Customer customer = customerService.getCustomerByEmail(email);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}