package com.kanhiya.restaurant.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrderItemDTO {
	private Integer id;
	private String name;
	private Integer quantity;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
}
