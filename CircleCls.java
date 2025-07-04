class Circle{
    private double radius;
    double PI = 3.14;
    void setRadius(int radius){
        if(radius>0){
            this.radius=radius;
        }
        else{
            System.out.println("Radius should be greater than 0");
        }
    }
    void getArea(){
        System.out.println(PI*radius*radius);
    }
    void getCircumference(){
        System.out.println(2*PI*radius);
    }
    
}
class CircleCls {
    public static void main(String[] args) {
        Circle ob = new Circle();
        ob.setRadius(5);
        ob.getArea();
        ob.getCircumference();
    }
}
