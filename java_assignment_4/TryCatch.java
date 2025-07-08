import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
class TryCatch{
    public static void loadFile(String file)
    {
        try(FileInputStream fis = new FileInputStream(file)){
        try
        {
            int character;
            while ((character = fis.read()) != -1) 
            {
                System.out.print((char)character);
            }
        
        }
        catch(FileNotFoundException fe)
        {
            System.out.println("The provided file is not exist. Create one and try again!");
        }
    }
         catch(IOException e) 
        {
            System.out.println("There is an error occured while reading the file: "+ e.getMessage());
        }
    }
    public static void main(String[] args)
    {
        
            loadFile("MyFile.txt");
        
    }
}