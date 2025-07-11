// Create a Flight class with default and parameterized constructors. Include fields
// like flightNumber, destination, and duration. Create objects using both constructors.

package com.aaslin.java.assignments.assignment_2;

class Flight{
    int Fnum;
    String destination;
    String dur;
    Flight(){}
    Flight(int Fnum, String destination, String dur){
        this.Fnum=Fnum;
        this.destination=destination;
        this.dur=dur;
    }
    void FlightStatus(){
        System.out.println("Your flight is ready to start..");
    }
    void getTravelerDetails(){
        System.out.println("Person's Flight number is "+Fnum+" traveling to "+destination+" , his duration time is "+ dur);
    }

}
class Flightcls{
    public static void main(String[] args){
        Flight ob1 = new Flight();
        Flight ob2 = new Flight(101, "Ohio", "24 days");
        ob1.FlightStatus();
        ob2.getTravelerDetails();
        ob2.FlightStatus();
    }
}