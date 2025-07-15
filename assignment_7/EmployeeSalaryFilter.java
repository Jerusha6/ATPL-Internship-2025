package com.aaslin.java.assignments.assignment_7;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

class Employeee {
    private int id;
    private String name;
    private double salary;

    public Employeee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "ID: " + id + " | Name: " + name + " | Salary: " + salary;
    }
}

public class EmployeeSalaryFilter {
    public static void main(String[] args) {

        List<Employeee> employeeList = new ArrayList<>();
        employeeList.add(new Employeee(1, "Jerusha", 28000));
        employeeList.add(new Employeee(2, "Rani", 45000));
        employeeList.add(new Employeee(3, "Anand", 25000));
        employeeList.add(new Employeee(4, "Roja", 60000));

         // Before removing employees with <30000
         System.out.println("Before removing employees with <30000");
         for (Employeee employee : employeeList) {
            System.out.println(employee);
        }

        // Using Iterator to remove salary < 30000
        Iterator<Employeee> iterator = employeeList.iterator();
        while (iterator.hasNext()) {
            Employeee employee = iterator.next();
            if (employee.getSalary() < 30000) {
                iterator.remove();
            }
        }

        // After removing employees with <30000
        System.out.println("\nAfter removing employees with <30000");
        for (Employeee employee : employeeList) {
            System.out.println(employee);
        }
    }
}
