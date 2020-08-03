package com.kanhiya.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import com.kanhiya.restaurant.entity.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
	
	public Iterable<Restaurant> findRestaurantByLocality(String locality);

}
