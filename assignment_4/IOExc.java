// Here I'm trying to read a file that is not exist in the system, so it throws IOexception. 
// In the catch box I'm handling it  
package com.aaslin.java.assignments.assignment_4;
import java.io.FileReader;
import java.io.IOException;
class IOExc {
public static void main(String[] args){
    try{
        FileReader fr = new FileReader("AaslinTech.txt");
        fr.read();
    }catch(IOException ie){
        System.out.println("There is no such file exist! we cannot perform read() operation..!");
    }
}    
}