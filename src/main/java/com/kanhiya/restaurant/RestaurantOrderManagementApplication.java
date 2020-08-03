package com.kanhiya.restaurant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.kanhiya.restaurant.entity.Order;
import com.kanhiya.restaurant.entity.OrderItem;
import com.kanhiya.restaurant.entity.Rating;
import com.kanhiya.restaurant.entity.Rest_Items;
import com.kanhiya.restaurant.entity.Restaurant;
import com.kanhiya.restaurant.entity.User;
import com.kanhiya.restaurant.repository.OrderItemRepository;
import com.kanhiya.restaurant.repository.OrderRepository;
import com.kanhiya.restaurant.repository.RatingRepository;
import com.kanhiya.restaurant.repository.RestaurantRepository;
import com.kanhiya.restaurant.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.kanhiya.restaurant.repository")
public class RestaurantOrderManagementApplication implements CommandLineRunner {

	@Autowired
	RestaurantRepository restRepository;

	@Autowired
	OrderItemRepository orderItemRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RatingRepository ratingRepository;
	
	@Bean
	public OrderItem getOrderItem() {
		return new OrderItem();
	}
	
	@Bean
	public Order getOrder() {
		return new Order();
	}
	public static void main(String[] args) {
		SpringApplication.run(RestaurantOrderManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 Restaurant restaurant = new Restaurant(); 
		 restaurant.setName("Bhagini");
		 restaurant.setAddress("mahadevpura"); 
		 restaurant.setCity("Bangalore");
		 restaurant.setLocality("mahadevpura");
		 restaurant.setPhone(12345678);
		 restaurant.setEmail("bhagini@gmail.com");
		 restaurant.setContactPersonName("Ramesh");
		 
		 Rest_Items item1 = new Rest_Items();
		 item1.setName("Kajju_Barfi");
		 item1.setType("Sweets");
		 item1.setPrice(250.50);
		 item1.setDiscount(20);
		 item1.setCreatedTime(LocalDateTime.now());
		 item1.setUpdatedTime(LocalDateTime.now());
		 
		 Rest_Items item2 = new Rest_Items();
		 item2.setName("Rajma_Rice");
		 item2.setType("Veg");
		 item2.setPrice(260.00);
		 item2.setDiscount(30);
		 item2.setCreatedTime(LocalDateTime.now());
		 item2.setUpdatedTime(LocalDateTime.now());
		 
		 restaurant.setItems(new ArrayList<>());
		 restaurant.getItems().add(item1);
		 restaurant.getItems().add(item2);
		 
		 restaurant.setCreatedTime(LocalDateTime.now());
		 restaurant.setUpdatedTime(LocalDateTime.now());
		 restRepository.save(restaurant); 
		 
		System.out.println("==========================================");
		User us = new User();
		us.setName("kanhiya");
		us.setPhone(1111111);
		us.setEmail("kan@gmail.com");
		us.setAddress("mahadevpura, Bangalore");
		us.setCreatedTime(LocalDateTime.now());
		us.setUpdatedTime(LocalDateTime.now());
		userRepository.save(us);

		Order order1 = new Order();
		order1.setUser(us);
		order1.setRestaurant(restaurant);

		OrderItem orderitems = new OrderItem();
		orderitems.setName("Rajma_Rice");
		orderitems.setQuantity(1);
		orderitems.setCreatedTime(LocalDateTime.now());
		orderitems.setUpdatedTime(LocalDateTime.now());

		OrderItem orderitems1 = new OrderItem();
		orderitems1.setName("Kajju_Barfi");
		orderitems1.setQuantity(2);
		orderitems1.setCreatedTime(LocalDateTime.now());
		orderitems1.setUpdatedTime(LocalDateTime.now());

		order1.setOrderitems(new HashSet<>());
		order1.getOrderitems().add(orderitems);
		order1.getOrderitems().add(orderitems1);
		
		order1.setCreatedTime(LocalDateTime.now());
		order1.setUpdatedTime(LocalDateTime.now());

		orderRepository.save(order1);
		
		
		  Order order2 = new Order(); order2.setUser(us);
		  order2.setRestaurant(restaurant);
		  
		  OrderItem orderitems3 = new OrderItem(); orderitems3.setName("Maysuru_Park");
		  orderitems3.setQuantity(3); orderitems3.setCreatedTime(LocalDateTime.now());
		  orderitems3.setUpdatedTime(LocalDateTime.now());
		  
		  OrderItem orderitems4 = new OrderItem(); orderitems4.setName("Cold_Cofee");
		  orderitems4.setQuantity(4); orderitems4.setCreatedTime(LocalDateTime.now());
		  orderitems4.setUpdatedTime(LocalDateTime.now());
		  
		  order2.setOrderitems(new HashSet<>());
		  order2.getOrderitems().add(orderitems3);
		  order2.getOrderitems().add(orderitems4);
		  
		  order2.setCreatedTime(LocalDateTime.now());
		  order2.setUpdatedTime(LocalDateTime.now()); 
		  orderRepository.save(order2);
		 
		
		Rating rating= new Rating();
		rating.setRestaurant(restaurant);
		rating.setUser(us);
		rating.setRating(4.5);
		rating.setComment("Good restaurant");
		rating.setCreatedTime(LocalDateTime.now());
		rating.setUpdatedTime(LocalDateTime.now());
		ratingRepository.save(rating);

		System.out.println("==========================================");
	}
	
}

