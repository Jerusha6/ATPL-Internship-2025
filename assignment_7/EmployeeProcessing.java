import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;


class Employee {
    Integer employeeId; // Employee ID stored as Integer (wrapper type)
    String employeeName;        
    String department;  
    double salary;      

    // Constructor to create Employee object
    public Employee(Integer employeeId, String employeeName, String department, String salaryString) {
        this.employeeId= employeeId;
        this.employeeName = employeeName;
        this.department = department;
        // Convert salary from String to double using wrapper class
        this.salary = Double.parseDouble(salaryString);
    }

    // To print employee details in a readable format
    public String toString() {
        return "ID: " + employeeId+ ", Name: " + employeeName + ", Dept: " + department + ", Salary: " + salary;
    }
}

public class EmployeeProcessing {
    public static void main(String[] args) {
        // Create a list to store employee objects
        List<Employee> employees = new ArrayList<>();

        // Add employees to the list with your provided names
        employees.add(new Employee(101, "Jerusha", "HR", "45000"));
        employees.add(new Employee(102, "Elisha", "IT", "60000"));
        employees.add(new Employee(103, "Anand", "Finance", "55000"));
        employees.add(new Employee(104, "Roja", "HR", "47000"));
        employees.add(new Employee(105, "Rani", "IT", "62000"));
        employees.add(new Employee(106, "Bharani", "Sales", "50000"));
        employees.add(new Employee(107, "Sachit", "Finance", "53000"));
        employees.add(new Employee(108, "Kumar", "IT", "61000"));
        employees.add(new Employee(109, "Neha", "Sales", "49000"));
        employees.add(new Employee(110, "Akash", "HR", "46000"));

        // Sort employees by their salary in ascending order
        employees.sort(Comparator.comparingDouble(emp -> emp.salary));

        System.out.println("Employees sorted by salary:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // Remove employees who belong to the HR department
        Iterator<Employee> iterator = employees.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            if (employee.department.equalsIgnoreCase("HR")) {
                iterator.remove();
            }
        }

        System.out.println("\nEmployees after removing HR department:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
