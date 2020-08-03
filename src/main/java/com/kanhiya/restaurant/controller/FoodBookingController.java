package com.kanhiya.restaurant.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kanhiya.restaurant.dto.OrderDTO;
import com.kanhiya.restaurant.entity.Order;
import com.kanhiya.restaurant.repository.OrderRepository;

@RestController
public class FoodBookingController {
	


	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ModelMapper mapper;
	
	@GetMapping(value = "/orders")
	public ResponseEntity<?> getAllOrders() {
		Iterable<Order> orders = orderRepository.findAll();
		List<OrderDTO> collect = StreamSupport.stream(orders.spliterator(), false)
		.map(order -> mapper.map(order, OrderDTO.class))
		.collect(Collectors.toList());
		return ResponseEntity.ok(collect);
	}
	
	    @DeleteMapping(value = "/removeOrder/{order_id}")
	    public void cancelOrder(@PathVariable Integer order_id) {
		orderRepository.deleteById(order_id);
}
}