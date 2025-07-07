import java.util.Scanner;

class LoginFailedException extends Exception{
    String username="Jerusha6";
    String pass="Secret";
public LoginFailedException(String msg){
    super(msg);
    
}
void login(String username, String pass){
if((this.username).equals(username) || (this.pass).equals(pass)){
System.out.println("Login successful..");
}
}
}
class CustomExc {
public static void main(String[] args) {
    LoginFailedException ob;
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter username: ");
    String username = sc.nextLine();
    System.out.println("Enter password: ");
    String pass = sc.nextLine();
    try{
        ob.login(username,pass);
        throw new LoginFailedException("Invalid login details");       
    }catch(LoginFailedException le){
        System.out.println("Username or Password does not match! Please enter a valid username and password..");
    }
}    
}