package com.example.Insurance.Controller;

import com.example.Insurance.Model.Customer;
import com.example.Insurance.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerservice;

    @GetMapping("/customer/{cid}")
    public Optional<Customer> getcustomerbyid(@PathVariable("cid") int cid)
    {
        return customerservice.getcustomerbyid(cid);
    }
    @GetMapping("/allcustomerdetails")
    public List<Customer> getallcustomer()
    {
        return customerservice.getallcustomerdetails();
    }
    @PostMapping("/customer")
    public String postcustomer(@RequestBody Customer customer)
    {
        return customerservice.savecustomer(customer);
    }
    @PutMapping("/customer/{cid}")
    public String updatecustomer(@PathVariable("cid") int cid,@RequestBody Customer customer)
    {
        return customerservice.updateCustomer(cid, customer);
    }
    @DeleteMapping("/customer/{cid}")
    public String deletecustomer(@PathVariable("cid") int cid)
    {
        return customerservice.deletecustomer(cid);
    }

}
