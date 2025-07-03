class MathUtils{
void calculate(int a, int b){
    System.out.println(a+b);
}
void calculate(double a, double b){
    System.out.println(a*b);
}
}
class Maths{
    public static void main(String[] args){
        MathUtils ob = new MathUtils();
        ob.calculate(5,6);
        ob.calculate(5.0,6.0);
    }
}