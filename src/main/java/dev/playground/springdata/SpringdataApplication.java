package dev.playground.springdata;

import java.util.HashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.playground.springdata.models.Customer;
import dev.playground.springdata.services.CustomerRepository;

@SpringBootApplication
public class SpringdataApplication {

	public static final HashMap<String, String> customers = new HashMap<>() {
		{
			put("Jack", "Bauer");
			put("Chloe", "O'Brian");
			put("Kim", "Bauer");
			put("David", "Palmer");
			put("Michelle", "Dessler");
		}
	};
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Bean
	InitializingBean initializeDatabase() {
		return () -> {
			for (var customer : customers.entrySet()) {
				customerRepository.save(new Customer(null, customer.getKey(), customer.getValue()));
			}
		};
	}
}
