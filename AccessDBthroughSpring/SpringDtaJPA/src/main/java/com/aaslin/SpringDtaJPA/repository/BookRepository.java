package com.aaslin.SpringDtaJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aaslin.SpringDtaJPA.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

	List<Book> findByTitle(String title);
	
	@Query("Select b from Book b where b.title Like Concat(:title, '%')")
	List<Book> findByTitleContaining(@Param("title") String title);
}
