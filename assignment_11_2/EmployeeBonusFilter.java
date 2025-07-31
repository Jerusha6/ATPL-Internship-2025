<<<<<<< HEAD
public class EmployeeBonusFilter {

    public static void main(String[] args) {
        
    }

=======
// Employee Bonus Eligibility Check
// Concepts: Predicate, Stream, Optional
// Write a program that filters a list of employees based on their salary using a Predicate.
// If eligible, retrieve and print their email addresses using Optional. If the email is
// missing, print "Email not available".
// Input : List.of( new Employee(name,salary, email), ...so on );

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

class Employee {
    String id;
    String name;
    double salary;
    String email;

    public Employee(String employee_id, String employee_name, double employee_salary, String employee_email) {
        id = employee_id;
        name = employee_name;
        salary = employee_salary;
        email = employee_email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }
}

public class EmployeeBonusFilter {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("E101", "Jerusha", 50000.00, null));
        list.add(new Employee("E102", "Rani", 40000.00, "rani@gmail.com"));
        list.add(new Employee("E103", "Elisha", 120000.00, null));
        list.add(new Employee("E104", "Anand", 150000.00, "anand@gmail.com"));
        list.add(new Employee("E105", "Roja", 10000.00, "roja@gmail.com"));

        // Employees with wages up to ₹21,000 per month are generally eligible
        Predicate<Employee> predicate = t -> t.salary > 21000;

        System.out.println("Eligible Employees for Bonus:");
        System.out.println("-----------------------------------");

        list.stream()
                .filter(predicate)
                .forEach(employee -> {

                    System.out.println("Employee ID: " + employee.id + "\nEmployee name: " + employee.name
                            + " \nEmail: " + employee.getEmail().orElse("Email not available!") + "\nSalary: ₹"
                            + employee.salary);
                    System.out.println("-----------------------------------");
                });

    }
>>>>>>> 2b5faa5caa20fc1294019a9e08c2dd2a9572bfae
}