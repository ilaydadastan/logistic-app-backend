package com.example.logisticbackend.repository;

import com.example.logisticbackend.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
