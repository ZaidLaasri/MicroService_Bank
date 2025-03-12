package com.example.account.services;

import com.example.account.dtos.AccountDTO;
import com.example.account.entities.Account;
import com.example.account.mappers.AccountMapper;
import com.example.account.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountMapper accountMapper;
    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }


    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepository.findAll().stream().map(accountMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public AccountDTO getAccountById(String id) {
        Account account = accountRepository.findById(id).orElse(null);
        if (account != null)
            return accountMapper.toDto(account);
        return null;
    }
}
