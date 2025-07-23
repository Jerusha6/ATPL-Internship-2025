import java.util.Arrays;
import java.util.List;


public class SquareElementUsingLambda {
    
    public static void main(String[] args){

        List<Integer> integerList = Arrays.asList(1,2,3,4,5);

        System.out.println("List before squaring: "+integerList);

        System.out.println("List after squaring: ");

        integerList.forEach(num -> System.err.print(num*num+" "));


    }

}
