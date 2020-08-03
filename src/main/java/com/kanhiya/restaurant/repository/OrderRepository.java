package com.kanhiya.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import com.kanhiya.restaurant.entity.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
