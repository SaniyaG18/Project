package com.bookstore.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.entity.Book;
import com.bookstore.exception.ResourceException;
import com.bookstore.repository.BookRepository;
import com.bookstore.service.BookService;

@Service
public class BookServiceImp implements BookService{
	
	@Autowired
	private BookRepository bookrepository;

	@Override
	public Optional<Book> findBookById(int id) {
		try {
		return bookrepository.findById(id);
		}
		catch(Exception e) {
			throw new ResourceException("Error Finding Book"+e);
		}
		
	}

	@Override
	public List<Book> findBookByTitle(String bookTitle) {
		List<Book> bookList = bookrepository.findByBookTitle(bookTitle);
		List<Book> activeBookList = new ArrayList<>();
        for (Book book: bookList){
            if (book.isBookAvailability()){
                activeBookList.add(book);
            }
            else {
            	throw new ResourceException("Book is not Available");
            }
        }
        return activeBookList;
		
	}

	@Override
	public List<Book> findBookByAuthor(String bookAuthor) {
		List<Book> bookList = bookrepository.findByBookAuthor(bookAuthor);
		List<Book> activeBookList = new ArrayList<>();
        for (Book book: bookList){
            if (book.isBookAvailability()){
                activeBookList.add(book);
            }
            else {
            	throw new ResourceException("Book is not Available");
            }
        }
        return activeBookList;
	}

	
	@Override
	public Book addBook(Book book) {
		try {
		return bookrepository.save(book);
		}
		catch(Exception e) {
			throw new ResourceException("Error adding Book"+e);
		}
	}

	@Override
	public void removeBook(int bookId) {
		if (!bookrepository.existsById(bookId)) {
	        throw new ResourceException("Book with ID " + bookId + " not found");
	    }
		bookrepository.deleteById(bookId);
		
	}

	@Override
	public List<Book> viewAll() {
		List<Book> bookList =(List<Book>)bookrepository.findAll();
		List<Book> activeBookList = new ArrayList<>();
        for (Book book: bookList){
            if (book.isBookAvailability()){
                activeBookList.add(book);
            }
            else{
    			throw new ResourceException("Book not Available");
    		}
        }
        return activeBookList;
	}

	@Override
	public void updateBook(Book updatedBook)  {
	    // Check if the book exists in the repository
	    Optional<Book> optionalBook = bookrepository.findById(updatedBook.getBookId());
	    
	    if (optionalBook.isPresent()) {
	        // If the book exists, update its information
	        Book existingBook = optionalBook.get();
	        existingBook.setBookTitle(updatedBook.getBookTitle());
	        existingBook.setBookAuthor(updatedBook.getBookAuthor());
	        existingBook.setBookAvailability(updatedBook.isBookAvailability());
	        existingBook.setBookPrice(updatedBook.getBookPrice());
	        existingBook.setBookRating(updatedBook.getBookRating());
	        existingBook.setBookPublisher(updatedBook.getBookPublisher());
	        existingBook.setPublicationDate(updatedBook.getPublicationDate());
	        
	        // Save the updated book to the repository
	        bookrepository.save(existingBook);
	        
	        System.out.println("Book updated successfully.");
	    } else {
	       throw new ResourceException("Book not found");
	    }
	}


}
