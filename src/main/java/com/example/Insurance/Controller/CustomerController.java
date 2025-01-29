package com.example.Insurance.Controller;

import com.example.Insurance.Model.Audit;
import com.example.Insurance.Model.Customer;
import com.example.Insurance.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customer")
public class CustomerController  {

    @Autowired
    private CustomerService customerservice;

    @PostMapping("/login")
    public String login(@RequestBody Customer customer) {
        Optional<Customer> foundCustomer = customerservice.login(customer.getEmail(), customer.getPassword());
        return foundCustomer.isPresent() ? "Login successful" : "Invalid email or password";
    }


    // Get customer by ID
    @GetMapping("/{cid}")
    public Optional<Customer> getcustomerbyid(@PathVariable("cid") int cid) {
        return customerservice.getcustomerbyid(cid);
    }

    // Get all customers
    @GetMapping("/allcustomerdetails")
    public List<Customer> getallcustomer() {
        return customerservice.getallcustomerdetails();
    }

    // Save a new customer
    @PostMapping
    public String postcustomer(@RequestBody Customer customer) {
        return customerservice.savecustomer(customer);
    }


    // Update an existing customer
    @PutMapping("/{cid}")
    public String updatecustomer(@PathVariable("cid") int cid, @RequestBody Customer customer) {
        return customerservice.updateCustomer(cid, customer);
    }

    // Delete a customer
    @DeleteMapping("/{cid}")
    public String deletecustomer(@PathVariable("cid") int cid) {
        return customerservice.deletecustomer(cid);
    }
}
