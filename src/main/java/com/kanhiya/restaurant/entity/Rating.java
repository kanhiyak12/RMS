package com.kanhiya.restaurant.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "rating")
@Data
@NoArgsConstructor
public class Rating {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name ="rest_id")
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	private double rating;
	private String comment;

	@Column(name = "created_time")
	private LocalDateTime createdTime;
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;

}
