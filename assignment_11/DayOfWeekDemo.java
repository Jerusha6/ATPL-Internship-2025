import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class DayOfWeekDemo {
    
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a date (YYYY-MM-DD): ");
        String dateStr = scanner.nextLine();

        String[] dateStrArray = dateStr.split("-");

        int[] dateIntArray = new int[3];

        for(int i=0; i<3; i++){
            dateIntArray[i] = Integer.parseInt(dateStrArray[i]);
        }

        LocalDate date = LocalDate.of(dateIntArray[0], dateIntArray[1], dateIntArray[2]);

        DayOfWeek dayOfWeek =  date.getDayOfWeek();

        System.out.println("Day of the week: "+ dayOfWeek);
        scanner.close();

    }

}
