package com.example.customer.repositories;

import com.example.customer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring Data REST > fait de l'entité une ressource REST
// Non utilisé pour faire un peu plus propre > On doit créer un controller
//@RepositoryRestResource
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}