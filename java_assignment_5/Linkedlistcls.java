import java.util.LinkedList;
public class Linkedlistcls {
    public static void main(String[] args){
        LinkedList<Integer> li = new LinkedList<>();
        for(int i=10;i<=50;i+=10){
            li.add(i);
        }
        System.out.println("List Before update");
        for(int i:li){
            System.out.print(i+" ");
        }
        li.add(0,5);
        li.add((li.size()),60);
        li.remove(2);
        System.out.println("\nList after update");
        for(int i:li){
            System.out.print(i+" ");
        }
    }
}
