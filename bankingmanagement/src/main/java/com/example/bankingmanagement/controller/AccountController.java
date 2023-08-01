package com.example.bankingmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankingmanagement.entity.Account;
import com.example.bankingmanagement.service.AccountService;

@RestController
@RequestMapping("/api")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@GetMapping("/accounts")
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	@GetMapping("/accounts/{accountId}")
	public Account getAccountById(@PathVariable Long accountId) {
		return accountService.getAccountById(accountId);
	}

	@GetMapping("/accounts/customers/{customerId}")
	public List<Account> getAccountsByCustomerId(@PathVariable Long customerId) {
		return accountService.getAccountsByCustomerId(customerId);
	}

	@PostMapping("/accounts")
	public void createAccount(@RequestBody Account account) {
		accountService.createAccount(account);
	}

	@PutMapping("/accounts")
	public void updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
		account.setId(accountId);
		accountService.updateAccount(account);
	}

	@DeleteMapping("/accounts/{accountId}")
	public void deleteAccount(@PathVariable Long accountId) {
		accountService.deleteAccount(accountId);
	}
}
