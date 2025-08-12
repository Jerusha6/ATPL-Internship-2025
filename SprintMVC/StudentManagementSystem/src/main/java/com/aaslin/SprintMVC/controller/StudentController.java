package com.aaslin.SprintMVC.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aaslin.SprintMVC.model.Student;
import com.aaslin.SprintMVC.service.StudentService;


@Controller 
@RequestMapping("/students")
public class StudentController {
	
	@Autowired 	
	StudentService service;
	
	  	@GetMapping("/addStudent")
	    public String registerForm() {
	        return "Register";  //this triggers Register.jsp
	    }

	  	//To fetch all students
		@GetMapping("")
		@ResponseBody //to show the JSON/String format directly to the browser
		public List<Student> findAll() {
			return service.findAll();
		}
		
		
		//To fetch student by id
		@GetMapping("/{studentID}")
		@ResponseBody 
		public Student showStudentById(@PathVariable String studentID) {
			return service.findById(studentID);
		}
			
		@PostMapping("/add")	
		//form name values should match with Student class members(instance variables), so that
		//@ModelAttribute directly fetch data from the client and add to Student object
		public String addStudent(@ModelAttribute Student student) {
			service.addStudent(student);
			return "Students"; // Students.jsp file
		}
		
		@GetMapping("/updateStudent")
	    public String updateForm() {
	        return "UpdateStudent";  //this triggers UpdateStudent.jsp
	    }
		
		@GetMapping("/getStudent")
	    public String getForm(@RequestParam("id") String studentID, Model model) {	
			model.addAttribute("studentId", studentID);
			Student student = service.findById(studentID);
			model.addAttribute(student);
	        return "UpdateStudentForm";  //this triggers UpdateStudentForm.jsp
	    }		
		
		@RequestMapping("/update")
		public String updateStudent(@ModelAttribute Student student) {
			service.updateStudent(student);
			return "Students"; //UpdateStudent.jsp
		}
		
		
		@DeleteMapping("/delete/{studentID}")
		@ResponseBody
		public String deleteById(String studentID) {
			return service.deleteById(studentID);		
			
		}
		
		@DeleteMapping("/delete")
		@ResponseBody
		public String deleteAll() {
			return service.deleteAll();		
		}		
	
}
