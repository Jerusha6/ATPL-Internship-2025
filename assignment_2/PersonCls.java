package com.aaslin.java.assignments.assignment_2;

class Person{
    String name;
    int ID;
    void getReady(){
        System.out.println("Person is ready to go to school");
    }
}
class Student extends Person{
int cls;
void setDetails(String name, int ID, int cls){
    this.name=name;
    this.ID= ID;
    this.cls=cls;
}
void show(){
    System.out.println("Student name is "+name+" , his ID is "+ID+" and he is studying "+cls+"th class");
}

}
class Teacher extends Person{
String sub;
void setDetails(String name, int ID, String sub){
    this.name=name;
    this.ID= ID;
    this.sub=sub;
}
void show(){
    System.out.println("Teacher name is "+name+" , her ID is "+ID+" and she is teaching "+sub+" Subject");
}
}
class PersonCls{
    public static void main(String[] args){
        Person ob = new Person();
        ob.getReady();
        Student st = new Student();
        st.setDetails("Elisha",573,8);
        st.show();
        Teacher te = new Teacher();
        te.setDetails("Roja", 107, "Java");
        te.show();
    }
}
