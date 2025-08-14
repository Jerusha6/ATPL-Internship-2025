package com.aaslin.SpringJDBC.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.aaslin.SpringJDBC.model.Student;

@Repository
public class StudentDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Student> getAllStudents(){
		return jdbcTemplate.query("Select * from Student_jerusha", new BeanPropertyRowMapper<>(Student.class));
	}
	
	public Student getStudentById(int id) {
		return jdbcTemplate.queryForObject("select * from student_jerusha where id=?", new BeanPropertyRowMapper<>(Student.class), id);
	}
	
	public void addStudent() {
		jdbcTemplate.update("insert into user_jerusha values(102, \"elisha\");");
	}
}
