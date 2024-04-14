package com.bookstore.service;

import java.util.List;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;

public interface CartService {
	
	List<Cart> displayCart(Cart cart);
	void addBookToCart(Cart cart,String bookTitle);
	void updateCart(Cart cart);
	Cart removeCart(int orderId);
	

}