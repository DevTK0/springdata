package dev.playground.springdata;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import dev.playground.springdata.models.Customer;
import dev.playground.springdata.services.CustomerRepository;

@SpringBootApplication
public class SpringdataApplication {

	public static final String[][] customers = {
			{ "Jack", "Bauer" },
			{ "Chloe", "O'Brian" },
			{ "Kim", "Bauer" },
			{ "David", "Palmer" },
			{ "Michelle", "Dessler" }
	};
	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringdataApplication.class, args);
	}

	@Bean
	InitializingBean initializeDatabase() {
		return () -> {
			for (String[] customer : customers) {
				customerRepository.save(new Customer(null, customer[0], customer[1]));
			}
		};
	}
}
