/* Assignment 1: Create a Book class with fields like title, author, price, and a method to apply discounts. 
Instantiate multiple objects and display their final prices. */
import java.util.Scanner;
class Book{
    String title;
    String author;
    double price;
    int discount;
    public Book(String title, String author, double price ){
        this.title=title;
        this.author=author;
        this.price=price;
        applyDefDiscount(price);
    } 
    public Book(String title, String author, double price , int discount){
        this.title=title;
        this.author=author;
        this.price=price;
        this.discount=discount;
        applyDiscount(price, discount);
    } 
    public void applyDefDiscount(double price){
        double a = (15*price/100);
        System.out.println("After default discount "+title+" of author "+author+" with the org price "+price+"book is available at "+(price-a)+" only");
    }    
    public void applyDiscount(double price, int discount){
        double a = (discount*price/100);
        System.out.println("After given discount "+title+" of author "+author+" with the org price "+price+"book is available at "+(price-a)+" only");
    }
}
class Instantiateobj{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    Book ob1 = new Book("Learn about aaslin technologies", "DANTULURI VARAHA VENKATA SEETHARAMA RAJU", 1499.0d); //to apply 15% default discount
    Book ob2 = new Book("Java Programming", "James Gosling", 1500.0d,  20); //to apply entered discount
    // String title;
    // String author;
    // double price;
    // int dis;
    // System.out.println("Enter book title: ");
    // title = sc.nextLine();
    // System.out.println("Enter the author of the book: ");
    // author = sc.nextLine();
    // System.out.println("Enter the price of the book: ");
    // price = sc.nextDouble();
    // System.out.println("Enter the discount of the book: ");
    // dis = sc.nextInt();
    // Book ob3 = new Book(title, author, price); //to apply 15% default discount
    // Book ob4 = new Book(title, author, price, dis); //to apply entered discount
    // ob3.applyDefDiscount(price);
    // ob4.applyDiscount(price,dis);
    sc.close();
    }
}