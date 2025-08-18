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
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.SpringDtaJPA.model.Author;
import com.aaslin.SpringDtaJPA.service.AuthorService;


@RestController
@RequestMapping("/authors")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	//create
	@PostMapping("/add")
	public Author addAuthor(@RequestBody Author author) {
		return authorService.addAuthor(author);
	}
	
	//read all
	@GetMapping
	public List<Author> getAllAuthors(){
		return authorService.getAllAuthors();
	}
	
	//read author by id
	@GetMapping("/{id}")
	public Optional<Author> getAuthorById(@PathVariable int id){
		return authorService.getAuthorById(id);
	}
	
	//read author by name
	@GetMapping("/{name}")
	public List<Author> getAuthorByNameStartsWith(@PathVariable String name){
		return authorService.getAuthorByNameStartsWith(name);
	}
	
	//read authors with specific number of books
	@GetMapping("/{count}")
	public List<Author> getAuthorWithNBooks(@PathVariable int count){
		return authorService.findAuthorsWithMoreThanNBooks(count);
	}
	
	//update
	@PutMapping("/update/{id}")
	public Author updateAuthor(@PathVariable int id, @RequestBody Author author) {
        author.setId(id);
		return authorService.updateAuthor(author);
	}
	
	//delete all
	@DeleteMapping("/delete")
	public String deleteAll() {
		authorService.deleteAll();
		return "Authors deleted!";
	}
	
	//delete by ID
	@DeleteMapping("/delete/{id}")
	public String deleteAuthor(@PathVariable int id) {
		authorService.deleteAuthor(id);
		return "Author with id: "+id+" deleted!";
	}
	
	
	
}
