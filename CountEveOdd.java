import java.util.Scanner;

class CountEveOdd {
    public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
        //to enter the size of array
        int n=sc.nextInt();
        int eve=0;
        int odd=0;
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            //to enter the elements
            arr[i]=sc.nextInt();
        }
        for(int i:arr){
            if(i%2==0){
                eve++;
            }
            else odd++;
        }
        System.out.println("Even count is: "+eve+"\nOdd count is: "+odd);
        sc.close();
    }
}
