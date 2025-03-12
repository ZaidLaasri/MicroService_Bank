package com.example.account.dtos;

import com.example.account.entities.CurrencyType;
import com.example.account.utils.Customer;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {
    private String id;
    private Double balance;
    private LocalDate dateCreated;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    private Customer customer;
    private Long customerId;
}
