package com.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.bookstore.entity.Book;

public interface BookService {
	
	Optional<Book> findBookById(int id);
	List<Book> findBookByTitle(String bookTitle);
	List<Book> findBookByAuthor(String bookAuthor);
	List<Book> findBookByGenre(String bookGenre);
	
	//	add book 
	Book addBook(Book book);
	
	// delete book by Id
	void removeBook(int bookId);
	
	// view book
	List<Book> viewAll();
	
	// update book
	
	void updateBook(Book updatedBook);
	

}

