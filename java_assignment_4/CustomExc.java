import java.util.Scanner;

class LoginFailedException extends Exception{
   
public LoginFailedException(String msg){
    super(msg);   
}

}
class CustomExc {

    static String username="Jerusha6";
    static String pass="Secret";

    public static void login(String uname, String password) throws LoginFailedException{
        if((username).equals(uname) && (pass).equals(password)){
        System.out.println("Login successful..");
        }
        else{
            throw new LoginFailedException("Invalid login details"); 
        }
        }
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter username: ");
    String username = sc.nextLine().trim();
    System.out.println("Enter password: ");
    String pass = sc.nextLine().trim();
    try{
        login(username,pass);
              
    }catch(LoginFailedException le){
        System.out.println(le.getMessage()+" Username or Password does not match! Please enter a valid username and password..");
    }
}    
}