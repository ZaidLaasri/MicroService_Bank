package com.example.account.feign;

import com.example.account.utils.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    @CircuitBreaker(name = "customer", fallbackMethod = "getDefaultCustomer")
    public Customer getCustomer(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customer", fallbackMethod = "getAllCustomers")
    public List<Customer> getCustomers();

    default Customer getDefaultCustomer(Long id, Exception exception)
    {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("Not available");
        customer.setLastName("Not available");
        customer.setEmail("Not available");
        return customer;
    }

    default List<Customer> getAllCustomers(Exception exception)
    {
        return List.of();
    }
}