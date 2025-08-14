package com.aaslin.SprintMVC.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.SprintMVC.model.Student;

@Service 
public class StudentService {
	
	List<Student> studentList = new ArrayList<>(Arrays.asList(new Student("21nt1","jerusha","jerusha@gmail.com",21)));
	
	public void addStudent(Student student) {
		studentList.add(student);
	}

	public List<Student> findAll() {
		return studentList;
	}

	public Student findById(String studentID) {
		return studentList.stream() .filter(s-> s.getStudentId().equalsIgnoreCase(studentID)) .findFirst() .orElse(null);
	}

	public String deleteAll() {		
		studentList.removeAll(studentList);
		return "students deleted";
	}

	public String deleteById(String studentID) {
		
		for(int i=0; i<studentList.size();i++) {
			if(studentList.get(i).getStudentId().equalsIgnoreCase(studentID)) {
				studentList.remove(i);
				break;
			}
		}
		return "Student deleted";
	}

	public void updateStudent(Student student) {
		
		for(int i=0; i<studentList.size();i++) {
			if(studentList.get(i).getStudentId().equalsIgnoreCase(student.getStudentId())) {
				studentList.set(i, student);
				break;
			}
		}
	}	
	
}
