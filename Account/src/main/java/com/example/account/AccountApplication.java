package com.example.account;

import com.example.account.entities.Account;
import com.example.account.entities.CurrencyType;
import com.example.account.feign.CustomerClient;
import com.example.account.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(AccountRepository accountRepository, CustomerClient customerClient) {
		return args -> {
			customerClient.getCustomers().forEach(customer -> {
				Account accountInstance = Account.builder()
						.customerId(customer.getId())
						.id(UUID.randomUUID().toString())
						.balance(Math.random()*1000)
						.dateCreated(LocalDate.now())
						.currency(CurrencyType.EUR)
						.build();
				accountRepository.save(accountInstance);
			});
		};
	}

}
