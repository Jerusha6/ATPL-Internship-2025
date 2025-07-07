package a;
public class A {
    public void sayHelloPublic(){
        System.out.println("Hello from class A (public)");
    }
    void sayHelloDefault(){
        System.out.println("Hello from class A (Default)");
    }
    protected void sayHelloProtected(){
        System.out.println("Hello from class A (Protected)");
    }
    private void sayHelloPrivate(){
        System.out.println("Hello from class A (private)");
    }
}
