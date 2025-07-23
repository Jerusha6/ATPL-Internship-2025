import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class LocalDateDemo {
    public static void main(String[] args){

        LocalDate date = LocalDate.now();
        System.out.println(date);   

        LocalTime time = LocalTime.now();
        System.out.println(time);   

        LocalDate plusDays = date.plusDays(5); 
        System.out.println(plusDays);  

        LocalTime plusHours = time.plusHours(5); 
        System.out.println(plusHours);   
        
        LocalDateTime dateAndTime = LocalDateTime.now();  
        System.out.println(dateAndTime);   
        
        LocalDateTime minusDays = dateAndTime.minusDays(5); // Similar for hours also minusHours
        System.out.println(minusDays);   
        
        LocalDate birthDate = LocalDate.of(2004, 1, 1);
        LocalDate today = LocalDate.now();

        Period period = Period.between(birthDate, today);
        int age = period.getYears();

        System.out.println(age);



    }
}
