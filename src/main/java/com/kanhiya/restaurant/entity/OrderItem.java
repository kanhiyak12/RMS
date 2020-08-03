package com.kanhiya.restaurant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "order_item")
@Data
@NoArgsConstructor
public class OrderItem {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	
	private Integer quantity;

	@Column(name = "created_time")
	private LocalDateTime createdTime;
	
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;
}
