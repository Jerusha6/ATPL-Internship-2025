import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Arraylistcls{
    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        System.out.println("Enter 5 names: ");
        try(Scanner sc = new Scanner(System.in)){
            for(int i=0;i<5;i++){
            list.add(sc.nextLine());
        }
        }
        // printing list elements using for loop
        System.out.println("printing list elements using for loop");
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }

        // removing third element

        list.remove(2);

        // printing list elements using enhanced for loop
        System.out.println("printing updated list elements using enhanced for loop");
        for(String i: list){
            System.out.println(i);
        }
    }
}