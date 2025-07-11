// package com.aaslin.java.assignments.assignment_7;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

class Student{
    private int id, age;
    private String name;
    private double marks;

    List<Student> list = new ArrayList<Student>();

    public Student(int id, String name, int age, double marks){
        this.age = age;
        this.name = name;
        this.id = id;
        this.marks = marks;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    public int getAge(){
        return age;
    }
    public double getMarks(){
        return marks;
    }

    public String toString() {
        return "name: "+name + " | marks: " + marks + " | age: " + age + " | id: " + id;
    }
}

class StudentComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {

        // Compare by marks (Descending)
        int marksResult = Double.compare(s2.getMarks(), s1.getMarks());
        if (marksResult != 0) return marksResult;

        // Compare by name (A-Z)
        int nameResult = s1.getName().compareTo(s2.getName());
        if (nameResult != 0) return nameResult;

        // Compare by age (Ascending)
        return s1.getAge() - s2.getAge();
    }
}

class ComparatorDemo {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student(101, "Jerusha Rani", 21, 90));
        studentList.add(new Student(102, "Jerusha Rani", 31, 90));
        studentList.add(new Student(103, "Elisha", 20, 80));
        studentList.add(new Student(104, "Elisha", 20, 70));
        studentList.add(new Student(105, "Jerusha", 21, 100));
        studentList.add(new Student(106, "Roja", 36, 100));
        studentList.add(new Student(107, "Anand", 41, 100));

        System.out.println("Using StudentComparator() class");
        // Sorting using the comparator
        Collections.sort(studentList, new StudentComparator());
        
        System.out.println("Using Comparator chaining");
        // Using Comparator chaining
        Comparator<Student> chainComparator = Comparator.comparingDouble(Student :: getMarks).reversed().thenComparing(Student::getName).thenComparing(Student::getAge);
        Collections.sort(studentList, chainComparator);
        
        // Using ananymous Comparator
        
        System.out.println("Using ananymous Comparator");
        Collections.sort(studentList, new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                // Marks descending
                int result = Double.compare(s2.getMarks(), s1.getMarks());
                if (result != 0) return result;

                // Name ascending
                result = s1.getName().compareTo(s2.getName());
                if (result != 0) return result;

                // Age ascending
                return s1.getAge() - s2.getAge();
            }
        });


        // Print the sorted list
        for (Student s : studentList) {
            System.out.println(s);
        }
    }
}
