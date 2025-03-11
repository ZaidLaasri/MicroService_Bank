package com.example.account.controllers;
import com.example.account.entities.Account;
import com.example.account.repositories.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {
    private AccountRepository accountRepository;
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
        @GetMapping("/accounts")
        public List<Account> getAllAccounts()
        {
            return accountRepository.findAll();
        }
        @GetMapping("/account/{id}")
        public Account getAccountById(@PathVariable String id)
        {
            return accountRepository.findById(id).orElse(null);
        }
    }