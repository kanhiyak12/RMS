package com.kanhiya.restaurant.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kanhiya.restaurant.dto.RestaurantDTO;
import com.kanhiya.restaurant.entity.Restaurant;
import com.kanhiya.restaurant.repository.RestaurantRepository;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantRepository repository;
	
	@Autowired
	ModelMapper mapper;
	
	@GetMapping(value = "/restaurants")
	public ResponseEntity<?> getAllRestaurants() {
		Iterable<Restaurant> restaurants = repository.findAll();
		List<RestaurantDTO> collect = StreamSupport.stream(restaurants.spliterator(), false)
		.map(restaurant -> mapper.map(restaurant, RestaurantDTO.class))
		.collect(Collectors.toList());
		return ResponseEntity.ok(collect);
	}
	
	@GetMapping(value = "/restaurants/search")
	public ResponseEntity<?> getRestaurantsByLocality(@RequestParam String locality) {
		Iterable<Restaurant> restaurants = repository.findRestaurantByLocality(locality);
		List<RestaurantDTO> collect = StreamSupport.stream(restaurants.spliterator(), false)
		.map(restaurant -> mapper.map(restaurant, RestaurantDTO.class))
		.collect(Collectors.toList());
		return ResponseEntity.ok(collect);
	}
	
	@PostMapping(value = "/restaurants")
	public ResponseEntity<?> addRestaurants(@RequestBody RestaurantDTO restaurantDTO) {
		Restaurant restaurant = mapper.map(restaurantDTO, Restaurant.class);
		return ResponseEntity.ok(repository.save(restaurant));
	}
	

}
