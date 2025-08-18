package com.aaslin.SpringDtaJPA.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.SpringDtaJPA.model.Book;
import com.aaslin.SpringDtaJPA.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    // Create
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }
    
    @PostMapping("/create")
    public Book createBook(@RequestParam String title, @RequestParam Integer authorId) {
        return bookService.createBookForAuthor(title, authorId);
    }

    // Read all
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    // Read by id
    @GetMapping("/{id}")
    public Optional<Book> getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }
    
    //Read book by title
    @GetMapping("/{title}")
    public List<Book> getByTitleContaining(@PathVariable String title){
    	return bookService.findByTitleContaining(title);
    }

    // Update
    @PutMapping("/{id}")
	    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
	        book.setId(id);
        return bookService.updateBook(book);
    }
    
    // Delete all books
    @DeleteMapping()
    public String deleteAll() {
        bookService.deleteAll();
        return "All Books deleted!";
    }

    // Delete book by id
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "Book with id: " + id + " deleted!";
    }
}
