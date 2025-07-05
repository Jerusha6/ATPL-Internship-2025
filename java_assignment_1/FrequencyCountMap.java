import java.util.*;
class FrequencyCountMap {
    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        for(int i:arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> me: map.entrySet()){
            System.out.println("Occurances of "+me.getKey()+" is "+me.getValue());
        }
        sc.close();
    }
}
