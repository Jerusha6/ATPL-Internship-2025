import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class FilterFunction {
    
    public static void main(String[] args){

        List<String> list = Arrays.asList("Alice", "Bob", "Andrew", "Tom", "Angela", "Steve");

        System.out.println("List before filering: "+list);

        list = list.stream() .filter( name ->  name.charAt(0)=='A') .collect(Collectors.toList());

        // printing the list with starting A

        System.out.println("List after filering: "+list);


    }

}
