package com.aaslin.java.assignments.assignment_8_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

class Student implements Serializable{
	
	// whitespace
	private static final long serialVersionUID = 232456744L;
    private int id;
    private String name;
    private int age;
    private String department; 
    private double gpa;

	public Student(int id, String name, int age, String department, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.department = department;
		this.gpa = gpa;
	}
    
	public String toString(){
		return id+" "+name+" "+age+" "+department+" "+gpa;
	}

}

public class SerializeDemo {
    public static void main(String args[]){

    	List<Student> studentList = new ArrayList<>();
		studentList.add(new Student(1, "JERUSHA", 21, "CSE", 8));
		studentList.add(new Student(2, "ELISHA", 19, "CSE", 8));
		studentList.add(new Student(3, "ANAND", 41, "CSE", 8));
		studentList.add(new Student(4, "ROJA", 31, "CSE", 8));
		studentList.add(new Student(5, "BHARANI", 20, "CSE", 8));
		File fileName = new File("students.ser");
    	try {
        	FileOutputStream file = new FileOutputStream(fileName);
        	ObjectOutputStream out = new ObjectOutputStream(file);
        	out.writeObject(studentList);
        	file.close();
        	out.close();
 	
    	}catch(IOException io) {
    		System.out.print(io.getMessage());
    	}

		studentList = null; //dereferencing the object to null
    	
    	try{
    		FileInputStream file = new FileInputStream(fileName);
			ObjectInputStream in = new ObjectInputStream(file);
			
			studentList = (List) in.readObject();
			in.close();
			file.close();

			for(Student student : studentList){
				System.out.println(student);
			}
			}catch(IOException io){
				System.out.println(io.getMessage());
			}catch(ClassNotFoundException cne){
				System.out.println(cne.getMessage());
			}
    }
}
