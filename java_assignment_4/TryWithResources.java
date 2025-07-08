import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryWithResources {

    public static void readFileSafely(String file) throws IOException{
        try(BufferedReader bf = new BufferedReader(new FileReader(file))){
            String word;
            while((word=bf.readLine())!=null){
                if(word.equals("Aaslin"))
                {
                    try{
                        try(FileWriter fw = new FileWriter(file)){
                            fw.append("which is a Product Based company");
                        }
                        System.out.println("Write operation is successful");
                    }catch(IOException io){
                            System.out.println("We cannot perform write operation to the specified file because "+io.getMessage());
                        }
                        
                }
                else{  
                    try(FileWriter fw = new FileWriter(file)){
                            fw.write(" Aaslin technologies is a Product Based company");
                            
                        } 
                    System.out.println("Write operation is successful");
                }
            }
        }
    }
    public static void main(String[] args){
        try{
            readFileSafely("MyFile.txt");
        }catch(IOException io){
            System.out.println(io.getMessage());
        }
    }
}

