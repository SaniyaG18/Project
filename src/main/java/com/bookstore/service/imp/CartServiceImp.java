package com.bookstore.service.imp;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.exception.ResourceException;
import com.bookstore.repository.BookRepository;
import com.bookstore.repository.CartRepository;
import com.bookstore.service.CartService;

@Service
public class CartServiceImp implements CartService {
	
	@Autowired
	private CartRepository cartrepository;
	
	@Autowired
	private BookRepository bookrepository;
	
	@Override
	public List<Cart> displayCart(Cart cart) {
		return cartrepository.findAll();
	}

	@Override
	public void addBookToCart(Cart cart, String bookTitle) {
	    try {
	        // Lookup the book by title from a repository or database
	        List<Book> book = bookrepository.findByBookTitle(bookTitle);
	        
	        // Check if the book is found
	        if (book != null) {
//	            // Assuming a book can be added directly to the list of books in the cart
//	            List<Book> books = cart.getBooks();
//	            books.add(book);
	            cart.setBooks(book);
	            // Update total price and quantity accordingly
	            cart.setTotalPrice(cart.getTotalPrice());
	            cart.setQuantity(cart.getQuantity());
	            
	            // Update order date
	            cart.setOrderDate(new Date());
	        } else {
	            throw new ResourceException("Book with title '" + bookTitle + "' not found");
	        }
	    } catch (Exception e) {
	        throw new ResourceException("Error adding book to cart");
	    }
	}

	 
	@Override
	 public void updateCart(Cart cart) {
        // Check if the cart exists in the database
        Optional<Cart> existingCart = cartrepository.findById(cart.getOrderId());
        
        if (existingCart != null) {
        	Cart updatedCart = existingCart.get();
            // Update the cart details
            updatedCart.setTotalPrice(cart.getTotalPrice());
            updatedCart.setQuantity(cart.getQuantity());
            updatedCart.setOrderDate(cart.getOrderDate());
            updatedCart.setBooks(cart.getBooks());
            updatedCart.setUser(cart.getUser());
            
            // Save the updated cart
            cartrepository.save(updatedCart);
            
        } else {
            throw new ResourceException("Cart not found with ID: "+ cart.getOrderId());
        }
    }
	@Override
	public Cart removeCart(int orderId) {
		cartrepository.deleteById(orderId);
		return null;
	}

}





