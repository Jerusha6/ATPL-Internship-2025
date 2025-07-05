import java.util.Arrays;
import java.util.Collections;

class Sorting {
    public static void showArr(String[] names){
        for(String s: names){
            System.out.println(s+" ");
        }
    }
public static void main(String[] args) {
    String[] nameArr = {"Jerusha", "Elisha", "Anand", "Roja"};
    System.out.println("Array contains before sorting: ");
    showArr(nameArr);  
    Arrays.sort(nameArr);
    System.out.println("Array contains after sorting in ascending:");
    showArr(nameArr);  
    System.out.println("Array contains after sorting in descending:");
    Arrays.sort(nameArr, Collections.reverseOrder());
    showArr(nameArr);  
   
}    
}
