package com.kanhiya.restaurant.dto;

import java.time.LocalDateTime;
import java.util.Set;

import lombok.Data;

@Data
public class OrderDTO {
	private Integer order_id;
	private RestaurantDTO restaurant;
	private UserDTO user;
	private Set<OrderItemDTO> orderitems;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
}
