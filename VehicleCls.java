// Create a Vehicle class and extend it with Bike and Car classes. Override a
// method like start() in each subclass.

class Vehicle{
void start(){
    System.out.println("Vehicle is starting");
}
}
class Bike extends Vehicle{
    @Override
    void start(){
    System.out.println("Bike is starting");
}
}
class Car extends Bike{
    @Override
    void start(){
    System.out.println("Car is starting");
}
}
class VehicleCls{
    public static void main(String[] args){
        Vehicle ve = new Vehicle();
        ve.start();
        Bike bike = new Bike();
        bike.start();
        Car car = new Car();
        car.start();
    }
}