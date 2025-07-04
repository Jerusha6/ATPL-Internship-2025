class Student {
    int id;
    String name;
    static String schoolName;

    Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", School: " + schoolName);
    }
}

public class StudentCls {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Anand");
        Student.schoolName = "Oxford University";
        Student s2 = new Student(2, "Roja");
        System.out.println("Before changing school name:");
        s1.display();
        s2.display();
        s1.schoolName = "Delhi public school";
        System.out.println("\nAfter changing school name:");
        s1.display();
        s2.display();
    }
}
