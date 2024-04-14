package com.bookstore.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
	
	
	@Column(name="Quantity")
	private int quantity;
	
	@Column(name="total_price")
	private float totalPrice;
	
	@Column(name="order_date")
	private Date orderDate;
	
	 @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Book> books = new ArrayList<>(); // One cart can have multiple books
	
	@OneToOne
	@JoinColumn(name="userId")
	private User user;
	
	public float getTotalPrice() {
        float totalPrice = 0;
        if (books != null) {
            for (Book book : books) {
                totalPrice = (totalPrice + book.getBookPrice()); // Add each book price to total price
            }
            totalPrice *= quantity; // Multiply total price by quantity
        }
        return totalPrice;
    }

}