package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.entity.Book;
import com.bookstore.entity.Cart;
import com.bookstore.service.imp.CartServiceImp;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceImp cartService;

    @GetMapping("/display")
    public List<Cart> displayCart(@RequestBody Cart cart) {
        return cartService.displayCart(cart);
    }

    @PostMapping("/addBook")
    public void addBookToCart(@RequestBody Cart cart, @RequestBody Book book) {
       
       cartService.addBookToCart(cart, book);
    }

    @PutMapping("/update")
    public void updateCart(@RequestBody Cart cart) {
        
        cartService.updateCart(cart);
    }

    @DeleteMapping("/remove/{orderId}")
    public void removeCart(@PathVariable int orderId) {
        
         cartService.removeCart(orderId);
    }
}



