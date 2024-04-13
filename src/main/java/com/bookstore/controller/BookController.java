package com.bookstore.controller;

import java.util.List;
import java.util.Optional;

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
import com.bookstore.service.imp.BookServiceImp;

@RestController
@RequestMapping("/home")
public class BookController {

    @Autowired
    private BookServiceImp bookService;

    @GetMapping("/{id}")
    public Optional<Book> findBookById(@PathVariable int id) {
        
        return bookService.findBookById(id);
    }

    @GetMapping("/title/{title}")
    public List<Book> findBookByTitle(@PathVariable String bookTitle) {
       
        return bookService.findBookByTitle(bookTitle);
    }

    @GetMapping("/author/{author}")
    public List<Book> findBookByAuthor(@PathVariable String bookAuthor) {
        
        return bookService.findBookByAuthor(bookAuthor);
    }

    @GetMapping("/genre/{genre}")
    public List<Book> findBookByGenre(@PathVariable String bookGenre) {
        
        return bookService.findBookByGenre(bookGenre);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        
        return bookService.addBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public void removeBook(@PathVariable int id) {
         bookService.removeBook(id);
    }

    @GetMapping("/all")
    public List<Book> viewAllBooks() {
        return bookService.viewAll();
    }

    @PutMapping("/update/{id}")
    public void updateBook(@PathVariable int id, @RequestBody Book updatedBook) {
        bookService.updateBook(updatedBook);
    }
}