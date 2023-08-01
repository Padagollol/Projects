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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingmanagement.entity.Transaction;
import com.example.bankingmanagement.service.AccountService;
import com.example.bankingmanagement.service.TransactionService;

@RestController
@RequestMapping("/api")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private AccountService accountService;

	// Amount greaterthan.

	@GetMapping("/transactions/greater")
	public ResponseEntity<List<Transaction>> getTransactionsWithAmountGreaterThan(
			@RequestParam("amount") double amount) {
		try {
			List<Transaction> transactions = transactionService.getTransactionsWithAmountGreaterThan(amount);
			return ResponseEntity.ok(transactions);
		} catch (Exception ex) {
			// Log the exception if needed
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	// Auto update

	@PostMapping("/transactions/deposit")
	public ResponseEntity<Transaction> deposit(@RequestBody Transaction transaction) {
		try {
			// Perform deposit transaction
			Transaction depositTransaction = transactionService.deposit(transaction);

			// Update account balance
			accountService.updateAccountBalance(depositTransaction.getAccount().getId(),
					depositTransaction.getAmount());

			// Return the updated transaction
			return ResponseEntity.ok(depositTransaction);
		} catch (Exception ex) {
			// Log the exception if needed
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	@GetMapping("/transactions")
	public List<Transaction> getAllTransactions() {
		return transactionService.getAllTransactions();
	}

	@GetMapping("/transactions/{transactionId}")
	public Transaction getTransactionById(@PathVariable Long transactionId) {
		return transactionService.getTransactionById(transactionId);
	}

	@GetMapping("/transactions/accounts/{accountId}")
	public List<Transaction> getTransactionsByAccountId(@PathVariable Long accountId) {
		return transactionService.getTransactionsByAccountId(accountId);
	}

	@PostMapping("/transactions")
	public void createTransaction(@RequestBody Transaction transaction) {
		transactionService.createTransaction(transaction);
	}

	@PutMapping("/transactions")
	public void updateTransaction(@PathVariable Long transactionId, @RequestBody Transaction transaction) {
		transaction.setId(transactionId);
		transactionService.updateTransaction(transaction);
	}

	@DeleteMapping("/transactions/{transactionId}")
	public void deleteTransaction(@PathVariable Long transactionId) {
		transactionService.deleteTransaction(transactionId);
	}
}
