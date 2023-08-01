package com.example.bankingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.bankingmanagement.entity.Customer;
import com.example.bankingmanagement.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	// sorting
	public List<Customer> getAllCustomersSortedByName() {
		Sort sort = Sort.by(Sort.Direction.ASC, "Name");
		return customerRepository.findAll(sort);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer) {
		Customer existingCustomer = customerRepository.findById(customer.getId())
				.orElseThrow(() -> new RuntimeException("Customer not found"));

		// Update the properties of the existing customer
		existingCustomer.setName(customer.getName());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPassword(customer.getPassword());

		customerRepository.save(existingCustomer);
	}

	public void deleteCustomer(int customerId) {
		if (customerRepository.existsById(customerId)) {
			customerRepository.deleteById(customerId);
		} else {
			throw new RuntimeException("Customer not found");
		}
	}
}
