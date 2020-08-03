package com.kanhiya.restaurant.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {
	private int id;
	private String name;
	private String address;
	private long phone;
	private String email;
	private LocalDateTime createdTime;
	private LocalDateTime updatedTime;
}
