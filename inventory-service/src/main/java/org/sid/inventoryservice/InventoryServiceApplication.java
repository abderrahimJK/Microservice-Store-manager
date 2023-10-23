package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repo.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(InventoryRepository inventoryRepository){
		return args ->{
			Random random = new Random();
			for(int i=0 ; i<5 ; i++){
				inventoryRepository.save(
						Product.builder()
								.name("Product"+random.nextInt())
								.price(1200+Math.random()*100)
								.qty(1+random.nextInt(200))
								.build()
				);
			}
		};
	}
}
