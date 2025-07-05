// Create a Laptop class where the parameterized constructor sets brand, RAM,
// and processor. Use constructor overloading to provide flexibility.

class Laptopcls{

    String br;
    String ram;
    String pro;
    Laptopcls(){}
    Laptopcls(String br, String ram, String pro){
        this.br=br;
        this.ram=ram;
        this.pro=pro;
    }
    void getDetails(){
        System.out.println("Your laptop brand is "+br+" with configuration of "+ram+" and "+pro+" processor");
    }
}

class Laptop{
    public static void main(String args[]){
        Laptopcls ob = new Laptopcls();
        Laptopcls ob1 =new Laptopcls("hp", "16GB","Intel");
        ob.getDetails();
        ob1.getDetails();
        
    }
}