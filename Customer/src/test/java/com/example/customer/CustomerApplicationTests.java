package com.example.customer;

import com.example.customer.entities.Customer;
import com.example.customer.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootTest
class CustomerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            List<Customer> customersList = List.of(
                    Customer.builder()
                            .firstName("Elodie").lastName("Bantos")
                            .email("elodie.bantos@etu.univ-cotedazur.fr")
                            .build(),
                    Customer.builder()
                            .firstName("Yue").lastName("Guo")
                            .email("yue.guo@etu.univ-cotedazur.fr")
                            .build(),
                    Customer.builder()
                            .firstName("Valeriia").lastName("Lapshina")
                            .email("valeriia.lapshina@etu.univ-cotedazur.fr")
                            .build(),
                    Customer.builder()
                            .firstName("Dounia").lastName("Zoubid")
                            .email("dounia.zoubid@etu.univ-cotedazur.fr")
                            .build()
            );
            customerRepository.saveAll(customersList);
        };
    }

}
