package com.example.bankingmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingmanagement.entity.Transaction;
import com.example.bankingmanagement.repository.TransactionRepository;

@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;

	// Amount Greaterthan

	public List<Transaction> getTransactionsWithAmountGreaterThan(double amount) {
		return transactionRepository.findByAmountGreaterThan(amount);
	}

	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}

	public Transaction getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new IllegalArgumentException("Transaction not found"));
	}

	public List<Transaction> getTransactionsByAccountId(Long accountId) {
		return transactionRepository.findByAccount_Id(accountId);
	}

	public void createTransaction(Transaction transaction) {
		transactionRepository.save(transaction);
	}

	public void updateTransaction(Transaction transaction) {
		Transaction existingTransaction = transactionRepository.findById(transaction.getId())
				.orElseThrow(() -> new IllegalArgumentException("Transaction not found"));

		// Update the properties of the existing transaction
		existingTransaction.setType(transaction.getType());
		existingTransaction.setAmount(transaction.getAmount());
		existingTransaction.setDate(transaction.getDate());
		existingTransaction.setAccount(transaction.getAccount());

		transactionRepository.save(existingTransaction);
	}

	public void deleteTransaction(Long transactionId) {
		if (transactionRepository.existsById(transactionId)) {
			transactionRepository.deleteById(transactionId);
		} else {
			throw new IllegalArgumentException("Transaction not found");
		}
	}

	public Transaction deposit(Transaction transaction) {
		// TODO Auto-generated method stub
		return null;
	}
}
