package com.kanhiya.restaurant.entity;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "order1")
@Data
@NoArgsConstructor
public class Order {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="order_id")
	private Integer order_id;
	
	
	@ManyToOne
	@JoinColumn(name ="rest_id")
	private Restaurant restaurant;
	 
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id")
	private Set<OrderItem> orderitems;
	
	@ManyToOne
	@JoinColumn(name ="user_id")
	private User user;
	 
	@Column(name = "created_time")
	private LocalDateTime createdTime;
	
	@Column(name = "updated_time")
	private LocalDateTime updatedTime;
}
