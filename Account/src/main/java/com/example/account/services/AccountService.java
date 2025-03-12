package com.example.account.services;

import com.example.account.dtos.AccountDTO;

import java.util.List;

public interface AccountService {
    List<AccountDTO> getAllAccounts();
    AccountDTO getAccountById(String id);
}
