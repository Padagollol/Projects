package com.example.bankingmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.bankingmanagement.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByAccount_Id(Long accountId);
	
	@Query("SELECT t FROM Transaction t WHERE t.amount > :amount")
	List<Transaction> findByAmountGreaterThan(@Param("amount") double amount);
}
