abstract class Shape{
    abstract void getArea();
}
class Sqaure extends Shape{
    int side;
    void setSide(int side){
        this.side=side;
    }
    void getArea(){
        System.out.println("Area of Square with side "+side+" is "+side*side);
    }

}
class Triangle extends Shape{
    int base;
    int height;
    public void setBase(int base) {
        this.base = base;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    void getArea(){
        System.out.println("Area of Triangle with base "+base+" and height "+height+" is "+0.5*base*height);
    }
}
class ShapeCls{
    public static void main(String[] args) {
        Sqaure sq = new Sqaure();
        sq.setSide(5);
        sq.getArea();
        Triangle tr = new Triangle();
        tr.setBase(3);
        tr.setHeight(6);
        tr.getArea();        
    }
}