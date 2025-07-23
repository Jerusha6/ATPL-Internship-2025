import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class AgeCalculator {
    public static void main(String[] args){

        try(Scanner scanner = new Scanner(System.in)){
        
        System.out.println("Enter your date of birth(YYYY-MM-DD) :  ");
        String dobStr = scanner.nextLine();
        String[] dobStrArray= dobStr.split("-");

        LocalDate birthDate = LocalDate.of(Integer.parseInt(dobStrArray[0]), Integer.parseInt(dobStrArray[1]), Integer.parseInt(dobStrArray[2]));
        LocalDate today = LocalDate.now();

        Period period = Period.between(birthDate, today);
        int year = period.getYears();
        int month = period.getMonths();
        int day = period.getDays();

        System.out.println("Your age is: "+year+" years "+month+" months "+day+" days.");
    }
}
}
