package b;
import a.A;


public class B{

    public static void main(String[] args) {
        
        A ob = new A();
        ob.sayHelloPublic();
    //  ob.sayHelloDefault(); it says cannot be visible
    //  ob.sayHelloPrivate(); it says cannot be visible
    // ob.sayHelloProtected(); it says cannot be visible

    }
}
