package com.aaslin.java.assignments.assignment_3;
import java.util.Scanner;
class EncryptedCls {
String encryptPass(String pass){
    String Encrypted = pass;
    Encrypted="";
        for(int i=0;i<pass.length();i++){
            if(i%2==0){
                Encrypted+=(char)(pass.charAt(i)+13);
            }
            else{
                Encrypted+=(char)(pass.charAt(i)+18);
            }
        }
        return Encrypted;
}
}
class SafePassword{
    public static void main(String[] args) {
        EncryptedCls ob = new EncryptedCls();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password: ");
        String Orgpassword = sc.nextLine();
        System.out.println(" Encrypted Password: "+ob.encryptPass(Orgpassword)); 
        System.out.println("Original Password After Encryption: "+Orgpassword);
       
    }
}