package com.aaslin.SpringDtaJPA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.SpringDtaJPA.model.Author;
import com.aaslin.SpringDtaJPA.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;
	public Author addAuthor(Author author) {
		return authorRepo.save(author);
	}
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}
	public Author updateAuthor(Author author) {
		return authorRepo.save(author);
	}
	public void deleteAuthor(int id) {	
		authorRepo.deleteById(id);
	}
	public Optional<Author> getAuthorById(int id) {
		return authorRepo.findById(id);
	}
	public void deleteAll() {		
		authorRepo.deleteAll();
	}
	public List<Author> getAuthorByNameStartsWith(String name) {
		return authorRepo.findByNameStartWith(name);
	}
	public List<Author> findAuthorsWithMoreThanNBooks(int count){
		return authorRepo.findAuthorsWithMoreThanNBooks(count);
	}
	
	

}
