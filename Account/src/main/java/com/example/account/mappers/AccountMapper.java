package com.example.account.mappers;

import com.example.account.dtos.AccountDTO;
import com.example.account.entities.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public AccountDTO toDto(Account account) {
        return new AccountDTO(account.getId(), account.getBalance(), account.getDateCreated(), account.getCurrency(), account.getCustomer(), account.getCustomerId());
    }

    public Account toAccount(AccountDTO accountDTO) {
        if (accountDTO != null)
            return new Account(null, accountDTO.getBalance(), accountDTO.getDateCreated(), accountDTO.getCurrency(), accountDTO.getCustomer(), accountDTO.getCustomerId());
        return null;
    }
}
