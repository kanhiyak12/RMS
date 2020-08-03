package com.kanhiya.restaurant.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class RestaurantDTO {
	
	private int id;
	private String name;
	private String address;
	private String locality;
	private String city;
	private Integer phone;
	private String email;
	private String contactPersonName;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
}
