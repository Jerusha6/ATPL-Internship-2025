package com.aaslin.SpringJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaslin.SpringJDBC.dao.StudentDao;
import com.aaslin.SpringJDBC.model.Student;


@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	public List<Student> getStudents() {
		
		return studentDao.getAllStudents();
	}

	public void addStudent(Student student) {
		studentDao.addStudent();
	}

	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}
	
	
}
