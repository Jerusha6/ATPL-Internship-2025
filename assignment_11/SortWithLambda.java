import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SortWithLambda {
    public static void main(String[] args){

        List<String> fruitList = new ArrayList<String>();
        fruitList.add("Banana");
        fruitList.add("Apple");
        fruitList.add("Mango");
        fruitList.add("Cherry");

        System.out.println("List contains before sorting: "+fruitList);

        // Sort using Lambda Expression

        Collections.sort(fruitList);

        System.out.println("After sorting using Collections.sort() in alphabetical order: "+fruitList);

        // Sort using Lambda Expression in reverse alphabetical order

        

        Collections.sort(fruitList, (fruit1, fruit2) -> fruit2.compareTo(fruit1));

        System.out.println("After sorting using Collections.sort() and lambda expression in reverse alphabetical order: "+fruitList);
    }    
}
