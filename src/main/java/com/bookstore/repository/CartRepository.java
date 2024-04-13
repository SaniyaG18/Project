package com.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart,Integer>{

}