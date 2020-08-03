package com.kanhiya.restaurant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name="item")
@Data
@NoArgsConstructor
public class Rest_Items {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "item_id")
	private int id;
	@Column(name = "item_name")
	private String name;
	@Column(name = "item_type")
	private String type;
	
	private double price;
	private double discount;

	@Column(name = "created_time")
	private LocalDateTime createdTime;
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

}
