import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnanymousSortingWithLambda {
    
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5,2,8,1,9);

        System.out.println("List before sorting: "+ list);
        
        Comparator<Integer> comparator = ( o1, o2) -> o2 - o1; //for descending order

        Collections.sort(list, comparator);

        System.out.println("List after sorting in descending order: "+ list);

    }

}
