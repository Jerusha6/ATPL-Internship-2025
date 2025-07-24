import java.util.Arrays;
import java.util.List;


public class SquareElementUsingLambda {
    
    public static void main(String[] args){

        List<Integer> integerList = Arrays.asList(6,2,4,7,3);

        System.out.println("List before squaring: "+integerList);

        System.out.println("List after squaring with lambda expression: ");

        integerList.forEach(num -> System.out.print(num*num+" "));

        System.out.println();

        System.out.println("List after squaring with lambda expression(with streams) also sorting in the same line: ");

        integerList .stream() .sorted() .map(n->n*n) .forEach(n-> System.out.print(n +" "));


    }

}
