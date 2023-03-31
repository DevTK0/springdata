package dev.playground.springdata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import dev.playground.springdata.models.Customer;
import dev.playground.springdata.services.CustomerRepository;

@DataJpaTest
class SpringdataApplicationTests {

	@Autowired
	private CustomerRepository customerRepository;

	@Test
	void testInitializeDatabaseBean() {
		Iterable<Customer> customers = customerRepository.findAll();
		HashMap<String, String> input = SpringdataApplication.customers;
		int i = 0;

		for (Customer customer : customers) {
			assertTrue(input.containsKey(customer.getFirstname()));
			assertEquals(customer.getLastname(), input.get(customer.getFirstname()));
			i++;
		}
		assertEquals(input.size(), i);
	}

}
