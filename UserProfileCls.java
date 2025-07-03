class UserProfile{
    private String username;
    private String email;
    private String password;
    public void setDetails(String username, String email, String password){
        this.username = username;
        this.email=email;
        this.password=password;
    }
    public void getPasswordLen(){
       System.out.println("length of password "+password.length());
    }
    public void getUsernameLen(){
       System.out.println("length of password "+username.length());
    }
    public void getEmailLen(){
       System.out.println("length of email "+email.length());
    }
}
class UserProfileCls {
   public static void main(String[] args){
    UserProfile ob = new UserProfile();
    ob.setDetails("jerusha","jerusha.aaslin@gmail.com", "jerusha123");
    ob.getPasswordLen();
    ob.getEmailLen();
    ob.getUsernameLen();
   } 
}
