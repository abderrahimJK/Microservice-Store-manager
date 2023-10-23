package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repo.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args->{
			customerRepository.saveAll(List.of(
					Customer.builder().name("Abderrahim").mail("abdo@gmail.ma").build(),
					Customer.builder().name("John").mail("johndoe@gmail.ma").build(),
					Customer.builder().name("yho").mail("halo@gmail.ma").build()
			));
			customerRepository.findAll().forEach(System.out::println);
		};
	}
}
