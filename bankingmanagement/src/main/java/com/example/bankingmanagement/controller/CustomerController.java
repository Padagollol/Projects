package com.example.bankingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingmanagement.entity.Customer;
import com.example.bankingmanagement.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
	@GetMapping("/customers/sort")
    public ResponseEntity<List<Customer>> getAllCustomersSortedByName() {
        try {
            List<Customer> customers = customerService.getAllCustomersSortedByName();
            return ResponseEntity.ok(customers);
        } catch (Exception ex) {
            // Log the exception if needed
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) {
        return customerService.getCustomerById(customerId);
    }

    @PostMapping("/customers")
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @PutMapping("/customers")
    public void updateCustomer(@PathVariable int customerId, @RequestBody Customer customer) {
        customer.setId(customerId);
        customerService.updateCustomer(customer);
    }

    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable int customerId) {
        customerService.deleteCustomer(customerId);
    }
}
