abstract class Appliance {
    abstract void turnOn();
    abstract void turnOff();
}
class Fan extends Appliance{
    void turnOn(){
        System.out.println("Fan is turning on");
    }
    void turnOff(){
        System.out.println("Fan is turning off");
    }
}
class TV extends Appliance{
    void turnOn(){
        System.out.println("TV is turning on");
    }
    void turnOff(){
        System.out.println("TV turning off");
    }
}
public class ApplianceCls {

    public static void main(String[] args) {
        Fan fan = new Fan();
        fan.turnOff();
        fan.turnOn();
        TV tv = new TV();
        tv.turnOff();
        tv.turnOn();
    }
}
