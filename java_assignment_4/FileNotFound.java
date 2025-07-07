// Here there is no such file called MyFile.txt exist, hence it is throwing FileNotFoundException

import java.io.FileNotFoundException;
import java.io.FileReader;
class FileNotFound {
public static void main(String[] args) throws FileNotFoundException{
    try{
    FileReader fr = new FileReader("MyFile.txt");  
}
catch(FileNotFoundException fn){
    System.out.println("The specified file name you have entered is not there..");
}
}   
}
