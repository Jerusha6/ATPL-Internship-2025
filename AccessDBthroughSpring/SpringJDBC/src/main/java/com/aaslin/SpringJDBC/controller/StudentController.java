package com.aaslin.SpringJDBC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aaslin.SpringJDBC.model.Student;
import com.aaslin.SpringJDBC.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getUsers(){
		return studentService.getStudents();
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id){
		return studentService.getStudentById(id);
	}
	
	@PostMapping("/addStudent")
	public String addUser(@RequestBody Student student) {
		studentService.addStudent(student);
		return "Student added!";
	}
	
}
