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

    public Optional<Customer> getcustomerbyid(int cid) {
        return customerrepo.findById(cid);
    }
    public List<Customer> getallcustomerdetails()
    {
        return customerrepo.findAll();
    }

    public String savecustomer(Customer customer) {

            try{
                customerrepo.save(customer);
                return "Customer added successfully!...";
            } catch (DataIntegrityViolationException e)
            {
                if(e.getMessage().contains("email"))
                {
                    return "Error: Email already exists!";
                } else if (e.getMessage().contains("phone")) {
                    return "Error:Phone number already exists!";
                }
                return "Error:Could not add customer.";
            }

        }
    public String updateCustomer(int id, Customer customer) {
        Customer result = customerrepo.findById(id).orElse(null);
        if (result==null)
        {
            return "No Customer Found";
        }
        else if(!result.getPhone().equals(customer.getPhone())&&customerrepo.findByPhone(customer.getPhone()) != null )
        {
            return "Error: Phone number already exists!";
        }
        else if(!customer.getEmail().equals(result.getEmail())&&customerrepo.findbyEmail(customer.getEmail())!=null)
        {
            return "Error: Email already exists!";
        }
        else {
            customerrepo.save(customer);
            return "updated ssucessfully!..";
        }
    }



    public String deletecustomer(int cid)
    {
        if (!customerrepo.existsById(cid)) {
            return "Customer with ID " + cid + " does not exist.";
        }
        customerrepo.deleteById(cid);
        return "Customer deleted";
    }
}

