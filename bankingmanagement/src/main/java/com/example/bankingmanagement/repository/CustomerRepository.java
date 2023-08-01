package com.example.bankingmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankingmanagement.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findAll(Sort sort);
}
