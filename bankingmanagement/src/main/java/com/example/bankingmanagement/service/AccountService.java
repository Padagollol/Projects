package com.example.bankingmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankingmanagement.entity.Account;
import com.example.bankingmanagement.repository.AccountRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;

	// Auto update

	public void updateAccountBalance(Long accountId, double depositAmount) {
		Account account = accountRepository.findById(accountId)
				.orElseThrow(() -> new EntityNotFoundException("Account not found"));

		double currentBalance = account.getBalance();
		double updatedBalance = currentBalance + depositAmount;
		account.setBalance(updatedBalance);

		accountRepository.save(account);
	}

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account getAccountById(Long accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new IllegalArgumentException("Account not found"));
	}

//	public Account getAccountById(Long accountId) { 
//		Account account = accountRepository.findById(accountId) 
//				.orElseThrow(() -> new AccountNotFound("Account not found"));// Additional logic... 
//		return account; 
//		}
//	
	public Account findById(Long id) {
		// TODO Auto-generated method stub
		Optional<Account> result = accountRepository.findById(id);
		Account account;
		if (result.isPresent()) {
			account = result.get();
		} else {
			throw new RuntimeException("account id not Found" + id);
		}
		// TODO Auto-generated method stub
		return account;
	}

	public void createAccount(Account account) {
		accountRepository.save(account);
	}

	public void updateAccount(Account account) {
		Account existingAccount = accountRepository.findById(account.getId())
				.orElseThrow(() -> new IllegalArgumentException("Account not found"));

		// Update the properties of the existing account
		existingAccount.setAccountNumber(account.getAccountNumber());
		existingAccount.setBalance(account.getBalance());
		// Update other account properties as needed

		accountRepository.save(existingAccount);
	}

	public void deleteAccount(Long accountId) {
		if (accountRepository.existsById(accountId)) {
			accountRepository.deleteById(accountId);
		} else {
			throw new IllegalArgumentException("Account not found");
		}
	}

	public List<Account> getAccountsByCustomerId(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
