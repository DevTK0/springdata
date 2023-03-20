package dev.playground.springdata.services;

import org.springframework.data.repository.CrudRepository;

import dev.playground.springdata.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}