interface Pritable{
    void getPrint();
}
class Document implements Pritable{
    public void getPrint(){
        System.out.println("Document is being printing..");
    }
}
class Image implements Pritable{
    public void getPrint(){
        System.out.println("Image is being printing..");
    }
}
class Invoice implements Pritable{
    public void getPrint(){
        System.out.println("Invoice is being printing..");
    }
}
class PrintableCls {
    public static void main(String[] args) {
        Document ob1 = new Document();
        ob1.getPrint();
        Image ob2 = new Image();
        ob2.getPrint();
        Invoice ob3 = new Invoice();
        ob3.getPrint();
    }
}
