package dev.playground.springdata;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import dev.playground.springdata.models.Customer;
import dev.playground.springdata.services.CustomerRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private CustomerRepository customerRepository;

    public DataLoader(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void run(ApplicationArguments args) {
        customerRepository.save(new Customer(null, "Jack", "Bauer"));
        customerRepository.findAll().forEach(System.out::println);
    }
}
