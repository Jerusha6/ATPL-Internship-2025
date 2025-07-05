class Interning {
public static void main(String[] args) {
    String A = new String("Hello"); // creates new heap object
    // It checks if an identical string exists in the String Pool, if not found, adds the string to the pool and returns its reference
    String B = A.intern(); // returns pooled "Hello"
    String C = "Hello"; // goes to String Pool automatically
    System.out.println("A string contains: "+A);
    System.out.println("B string contains: "+B);
    System.out.println("C string contains: "+C);
    System.out.println("A==B returning: "+(A==B));
    System.out.println("B==C returning: "+(C==B));
    System.out.println("A==C returning: "+(A==C));
}    
}
