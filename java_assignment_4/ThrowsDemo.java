import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ThrowsDemo
{
    public static void readFile(String fileName) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(fileName) );
        String keyword="Java developer";
        Scanner sc = new Scanner(fileName);
        while (sc.hasNextLine()) {
        String data = sc.nextLine();
            if((br.readLine()).equals(keyword)){
                System.out.println("Eligible for this role");
                break;
            }
            else{
                System.out.println("Unfortunately! you are not eligible..");
            }
        }
        sc.close();
    }
    public static void main(String[] args)
    {
        try{
            readFile("Jerusha_Resume.txt");
        }
        catch(IOException ioe){
            System.out.println("there is no file exist with the speicified name..");
        }
    }
}