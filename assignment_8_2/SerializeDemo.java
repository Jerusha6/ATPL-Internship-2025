 package com.aaslin.java.assignments.assignment_8_2;

import com.aaslin.java.assignments.assignment_8_2.Student;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializeDemo {
    public static void main(String args[]){

    	List<Student> list = new ArrayList<>();
		list.add(new Student(1, "JERUSHA", 21, "CSE", 8));
		list.add(new Student(2, "ELISHA", 19, "CSE", 8));
		list.add(new Student(3, "ANAND", 41, "CSE", 8));
		list.add(new Student(4, "ROJA", 31, "CSE", 8));
		list.add(new Student(5, "BHARANI", 20, "CSE", 8));
    	try {
    		
    		File fileName = new File("students.ser");
        	FileOutputStream file = new FileOutputStream(fileName);
        	ObjectOutputStream out = new ObjectOutputStream(file);
        	        	
        	out.writeObject(list);
 	
    	}catch(IOException io) {
    		System.out.print(io.getMessage());
    	}
    	
    	
    }
}
