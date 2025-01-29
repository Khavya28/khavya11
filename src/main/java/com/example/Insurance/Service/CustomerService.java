package com.example.Insurance.Service;

import com.example.Insurance.Model.Customer;
import com.example.Insurance.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepo customerrepo;

    public String savecustomer(Customer customer) {
        // Set a default password if not provided
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            customer.setPassword("admin@123");  // Default password
        }

        try {
            // Log the customer data before saving it
            System.out.println("Attempting to save customer: " + customer);
            customerrepo.save(customer);
            return "Customer saved successfully!";
        } catch (DataIntegrityViolationException e) {
            // Log the exception to see the cause
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();

            if (e.getMessage().contains("email")) {
                return "Error: Email already exists!";
            } else if (e.getMessage().contains("phone")) {
                return "Error: Phone number already exists!";
            }
            return "Error: Could not add customer.";
        } catch (Exception e) {
            // Catch any other unexpected errors
            System.err.println("Unexpected error occurred: " + e.getMessage());
            e.printStackTrace();
            return "Unexpected error occurred.";
        }
    }

    // Update an existing customer
    public String updateCustomer(int id, Customer customer) {
        Optional<Customer> existingCustomerOpt = customerrepo.findById(id);
        if (existingCustomerOpt.isEmpty()) {
            return "Customer not found.";
        }

        Customer existingCustomer = existingCustomerOpt.get();

        // Check if the phone number or email is already in use
        if (!customer.getPhone().equals(existingCustomer.getPhone()) && customerrepo.findByPhone(customer.getPhone()) != null) {
            return "Error: Phone number already exists!";
        }

        if (!customer.getEmail().equals(existingCustomer.getEmail()) && customerrepo.findByEmail(customer.getEmail()) != null) {
            return "Error: Email already exists!";
        }

        // Save the updated customer
        customerrepo.save(customer);
        return "Customer updated successfully!";
    }

    // Delete a customer
    public String deletecustomer(int cid) {
        if (!customerrepo.existsById(cid)) {
            return "Customer with ID " + cid + " does not exist.";
        }
        customerrepo.deleteById(cid);
        return "Customer deleted successfully!";
    }

    // Get customer by ID
    public Optional<Customer> getcustomerbyid(int cid) {
        return customerrepo.findById(cid);
    }

    // Get all customers
    public List<Customer> getallcustomerdetails() {
        return customerrepo.findAll();
    }
    public Optional<Customer> login(String email, String password) {
        return customerrepo.findByEmailAndPassword(email, password);
    }
}
