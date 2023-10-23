package org.sid.orderservice;

import org.sid.orderservice.entities.Order;
import org.sid.orderservice.entities.OrderStatus;
import org.sid.orderservice.entities.ProductItem;
import org.sid.orderservice.model.Customer;
import org.sid.orderservice.model.Product;
import org.sid.orderservice.repo.OrderRepository;
import org.sid.orderservice.repo.ProductItemRepository;
import org.sid.orderservice.service.CustomerRestClientService;
import org.sid.orderservice.service.InventoryRestClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(OrderRepository orderRepository, ProductItemRepository productItemRepository, CustomerRestClientService customerRestClientService, InventoryRestClientService inventoryRestClientService){
		return args -> {
			List<Customer> customers = customerRestClientService.allCustomers().getContent().stream().toList();
			List<Product> products = inventoryRestClientService.allProduct().getContent().stream().toList();

			Long customerID = 1L;
			Customer customer = customerRestClientService.customerByID(customerID);
			Random random = new Random();
			for (int i=0; i<20 ; i++){
				Order order = Order.builder()
						.customerID(customers.get(random.nextInt(customers.size())).getId())
						.createdAt(new Date())
						.status(Math.random()>0.5? OrderStatus.PENDING:OrderStatus.CREATED)
						.build();
				Order saveOrder = orderRepository.save(order);
				for (int j=0 ; j<products.size() ; j++){
					if(Math.random()>0.7){
						ProductItem productItem = ProductItem.builder()
								.order(order)
								.productID(products.get(j).getId())
								.qty(1+random.nextInt(10))
								.price(products.get(j).getPrice())
								.discount(Math.random())
								.build();
						productItemRepository.save(productItem);
					}
				}
			}
		};
	}
}
