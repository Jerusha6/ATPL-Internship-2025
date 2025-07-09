import java.util.LinkedList;
public class Linkedlistcls {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=10;i<=50;i+=10){
            list.add(i);
        }
        System.out.println("List Before update");
        for(int i:list){
            System.out.print(i+" ");
        }
        list.add(0,5);
        list.add((list.size()),60);
        list.remove(2);
        System.out.println("\nList after update");
        for(int i:list){
            System.out.print(i+" ");
        }
    }
}
