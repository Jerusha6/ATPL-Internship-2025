package com.aaslin.SpringDtaJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.SpringDtaJPA.model.Author;
import com.aaslin.SpringDtaJPA.model.Book;
import com.aaslin.SpringDtaJPA.repository.AuthorRepository;
import com.aaslin.SpringDtaJPA.repository.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepo;
    @Autowired
    private AuthorRepository authorRepo;
    

    // Create
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    // Read all
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    // Read by id
    public Optional<Book> getBookById(int id) {
        return bookRepo.findById(id);
    }

    // Update
    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    // Delete by Id
    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }
    
    // Delete All
	public void deleteAll() {
		bookRepo.deleteAll();	
	}
	
	//Read book by title
	public List<Book> findByTitleContaining(String title) {
		return bookRepo.findByTitleContaining(title);
	}
	
	@Transactional
    public Book createBookForAuthor(String title, Integer authorId) {
        Author author = authorRepo.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + authorId));

        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);

        return bookRepo.save(book);
    }
}
