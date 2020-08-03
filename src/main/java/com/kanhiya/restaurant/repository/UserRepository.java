package com.kanhiya.restaurant.repository;

import org.springframework.data.repository.CrudRepository;

import com.kanhiya.restaurant.entity.User;

public interface UserRepository extends CrudRepository<User, Integer>{

}
