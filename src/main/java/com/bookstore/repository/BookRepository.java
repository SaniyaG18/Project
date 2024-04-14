package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	//Method name should be similar to variable name
	
	List<Book> findByBookTitle(String bookTitle);
	List<Book> findByBookAuthor(String bookAuthor);
	

}