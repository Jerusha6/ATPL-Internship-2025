import java.util.List;
import java.util.ArrayList;


class PrintEven {
    public static void main(String[] args){

        List<Integer> integerList = new ArrayList<>();

        for(int i=0 ; i<11; i++){
            integerList.add(i);
        }

        // lambda expression to print even numbers
        System.out.println("Even numbers:");

        integerList.forEach(number -> { if(number%2==0) System.out.print(number+" "); });
        
    }
}