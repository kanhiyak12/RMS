package com.kanhiya.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import com.kanhiya.restaurant.entity.OrderItem;

public interface OrderItemRepository extends CrudRepository<OrderItem, Integer>{

}
