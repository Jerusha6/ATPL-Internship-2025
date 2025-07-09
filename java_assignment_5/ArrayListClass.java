// Write a Java program to:
// ○ Create an ArrayList of Strings.
// ○ Add 5 names to the list.
// ○ Print all names using a for loop and an enhanced for loop.
// ○ Remove the 3rd element.
// ○ Print the updated list.


import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class ArrayListClass{
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        System.out.println("Enter 5 names: ");
        try(Scanner scanner = new Scanner(System.in)){
            for(int iteration=0;iteration<5;iteration++){
            list.add(scanner.nextLine());
        }
        }
        // printing list elements using for loop
        System.out.println("printing list elements using for loop");
        for(int index=0;index<list.size();index++){
            System.out.println(list.get(index));
        }

        // removing third element

        list.remove(2);

        // printing list elements using enhanced for loop
        System.out.println("printing updated list elements using enhanced for loop");
        for(String element: list){
            System.out.println(element);
        }
    }
}