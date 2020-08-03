package com.kanhiya.restaurant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class User {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int id;
	private String name;
	private String address;
	private long phone;
	private String email;
	
	
	@Column(name = "created_time")
	private LocalDateTime createdTime;
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;
}
