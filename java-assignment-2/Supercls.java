class parentClass{
parentClass(){
   System.out.println("Parent class contructor called");
}
}
class childClass extends parentClass{
childClass(){
    super();
    System.out.println("Child class constructor called");
}
}
class Supercls {
public static void main(String[] args)    {
childClass cc = new childClass();
}
}
