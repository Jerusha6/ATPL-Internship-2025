package com.aaslin.java.assignments.assignment_4;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
class ScannerAndTryWithResources {

    public static void scanFile(String file)  throws FileNotFoundException{
       
        try(Scanner sc = new Scanner(new File(file))){
            if(sc.hasNextLine()){
                 while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
            }else{
                System.out.println("File is empty");
            }
           
    }
    }

public static void main(String[] args) throws IOException{

    try{
    scanFile("MyFile.txt");
    }catch(FileNotFoundException fe){
        System.out.println("File Not found: "+fe.getMessage());
    }
}    
}
