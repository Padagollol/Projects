package com.example.bankingmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bankingmanagement.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
