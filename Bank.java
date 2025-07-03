// Design a BankAccount class with deposit, withdraw, and checkBalance
// methods. Track multiple account objects and simulate basic operations.

class BankAccount{
    String name;
    double depo;
    double withdraw;
    double accBal;
    BankAccount(String name, double accBal){
        this.name=name;
        this.accBal = accBal;
    }
    void deposit(double depo){
        accBal += depo;
        System.out.println("Deposition of amount "+depo+" is successful");
    }
    void withdraw(double withdraw)
    {
        if(accBal<withdraw) {
            System.out.println("Dear user, you cannot withdraw "+withdraw+" because your account balance is insuffiecient");
        }
        else{
        accBal-= withdraw;
        System.out.println("Withdrawl of amount "+withdraw+" is successful");
        }
    }
    void checkBalance(){

        System.out.println("Dear "+name+" Now your total account balance is "+accBal);
    }

}
class Bank{
    public static void main(String[] args){
        BankAccount ba1 = new BankAccount("Jerusha", 5000);
        BankAccount ba2 = new BankAccount("Anand", 15000);
        BankAccount ba3 = new BankAccount("Roja", 1000);
        ba1.checkBalance();
        ba1.withdraw(2000);
        ba1.checkBalance();
        ba1.deposit(1000);
        ba1.checkBalance();
        ba2.checkBalance();
        ba2.withdraw(12000);
        ba2.checkBalance();
        ba2.deposit(1000);
        ba2.checkBalance();
        ba3.withdraw(12000);

    }
}