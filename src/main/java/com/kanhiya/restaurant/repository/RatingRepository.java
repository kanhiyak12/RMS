package com.kanhiya.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import com.kanhiya.restaurant.entity.Rating;

public interface RatingRepository extends CrudRepository<Rating, Integer> {

}
