package com.aaslin.SpringDtaJPA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aaslin.SpringDtaJPA.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>{
	
	@Query("SELECT a FROM Author a WHERE a.name LIKE CONCAT(:name, '%')")
	List<Author> findByNameStartWith(@Param("name") String name);
	
	@Query("SELECT a FROM Author a JOIN a.books b GROUP BY a HAVING COUNT(b) > :count")
	List<Author> findAuthorsWithMoreThanNBooks(@Param("count") int count);	
}
