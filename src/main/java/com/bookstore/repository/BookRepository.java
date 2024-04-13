package com.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer>{
	
	List<Book> findByTitle(String bookTitle);
	List<Book> findByAuthor(String bookAuthor);
	List<Book> findByGenre(String bookGenre);

}