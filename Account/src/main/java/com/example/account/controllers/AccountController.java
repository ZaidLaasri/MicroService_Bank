package com.example.account.controllers;

import com.example.account.dtos.AccountDTO;
import com.example.account.entities.Account;
import com.example.account.feign.CustomerClient;
import com.example.account.repositories.AccountRepository;
import com.example.account.services.AccountService;
import com.example.account.utils.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private AccountService accountService;
    private CustomerClient customerClient;

    public AccountController(AccountService accountService, CustomerClient customerClient) {
        this.accountService = accountService;
        this.customerClient = customerClient;
    }

    @GetMapping("/accounts")
    public List<AccountDTO> getAllAccounts()
    {
        List<AccountDTO> accountList = accountService.getAllAccounts();
        accountList.forEach(account -> {
            account.setCustomer(customerClient.getCustomer(account.getCustomerId()));
        });
        return accountList;
    }

    @GetMapping("/account/{id}")
    public AccountDTO getAccountById(@PathVariable String id)
    {
        AccountDTO accountInstance = accountService.getAccountById(id);
        if (accountInstance == null) {
            return null;
        }
        Customer customer = customerClient.getCustomer(accountInstance.getCustomerId());
        accountInstance.setCustomer(customer);
        return accountInstance;
    }
}