import java.time.LocalDate;

public class DateModificationWithPlusMinus {
    public static void main(String[] args){

        LocalDate date = LocalDate.now();
        System.out.println("Originally Date: "+date);

        LocalDate plusDays = date.plusDays(10); 
        System.out.println("After adding 10 days: "+plusDays);

        LocalDate minusMonths = date.minusMonths(2); 
        System.out.println("After subtracting 2 months "+minusMonths); 
    }
}
