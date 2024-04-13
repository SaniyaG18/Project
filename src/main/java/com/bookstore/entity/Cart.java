package com.bookstore.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cart_table")
public class Cart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int orderId;
	
	@Column(name="total_price")
	private float totalPrice ;
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="order_date")
	private Date orderDate;
	
	@OneToMany(mappedBy = "cart")
    private List<Book> books; // One cart can have multiple books
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;

}