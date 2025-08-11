package com.example.Insurance.Service;

import com.example.Insurance.Model.Customer;
import com.example.Insurance.Model.InsurancePolicy;
import com.example.Insurance.Repository.CustomerRepo;
import com.example.Insurance.Repository.InsurancePolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private InsurancePolicyRepo policyRepo;

    public Optional<Customer> getCustomerById(int id) {
        return customerRepo.findById(id);
    }

    public List<InsurancePolicy> getPoliciesByCustomerId(int customerId) {
        List<InsurancePolicy> policies = policyRepo.findByCustomerId(customerId);
        policies.forEach(policy -> {
            policy.getInsuranceCategory().getCategoryName(); // Access a property to initialize
        });
        return policies;
    }

    public String saveCustomer(Customer customer) {
        try {
            if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
                customer.setPassword("admin@123");
            }
            customerRepo.save(customer);
            return "Customer saved successfully!";
        } catch (DataIntegrityViolationException e) {
            if (e.getMessage().contains("email")) {
                return "Error: Email already exists!";
            } else if (e.getMessage().contains("phone")) {
                return "Error: Phone number already exists!";
            }
            return "Error: Could not add customer.";
        } catch (Exception e) {
            return "Unexpected error occurred.";
        }
    }

    public String updateCustomer(int id, Customer updatedCustomer) {
        Optional<Customer> existingCustomerOpt = customerRepo.findById(id);
        if (existingCustomerOpt.isEmpty()) {
            return "Customer not found.";
        }
        Customer existingCustomer = existingCustomerOpt.get();

        if (!updatedCustomer.getPhone().equals(existingCustomer.getPhone()) &&
                customerRepo.findByPhone(updatedCustomer.getPhone()) != null) {
            return "Error: Phone number already exists!";
        }

        if (!updatedCustomer.getEmail().equals(existingCustomer.getEmail()) &&
                customerRepo.findByEmailIgnoreCase(updatedCustomer.getEmail()) != null) {
            return "Error: Email already exists!";
        }

        existingCustomer.setName(updatedCustomer.getName());
        existingCustomer.setDob(updatedCustomer.getDob());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setAddress(updatedCustomer.getAddress());

        customerRepo.save(existingCustomer);
        return "Customer details updated successfully!";
    }

    public String deleteCustomer(int cid) {
        if (!customerRepo.existsById(cid)) {
            return "Customer with ID " + cid + " does not exist.";
        }
        customerRepo.deleteById(cid);
        return "Customer deleted successfully!";
    }

    public Optional<Customer> login(String email, String password) {
        return customerRepo.findByEmailAndPassword(email, password);
    }


    public List<Customer> getAllCustomers() {
        return customerRepo.findAll();
    }

    public Customer getCustomerByEmail(String email) {
        Optional<Customer> customerOpt = customerRepo.findByEmailIgnoreCase(email);
        return customerOpt.orElse(null); // Handle Optional properly
    }
    public boolean verifyPassword(int customerId, String password) {
        Optional<Customer> customerOpt = customerRepo.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            return customer.getPassword().equals(password); // Compare passwords
        }
        return false; // Customer not found
    }
    public String updatePassword(int customerId, String newPassword) {
        Optional<Customer> customerOpt = customerRepo.findById(customerId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            customer.setPassword(newPassword); // Update password
            customerRepo.save(customer); // Save updated customer
            return "Password updated successfully!";
        }
        return "Customer not found.";
    }
}