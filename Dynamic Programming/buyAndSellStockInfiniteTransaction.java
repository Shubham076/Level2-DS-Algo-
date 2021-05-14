import java.util.Scanner;

public class buyAndSellStockInfiniteTransaction {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        int sd = 0 ;  //sold day
        int bd = 0;  // bought day
        int p = 0;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] >= arr[i - 1]){
                sd++;
            }
            else{
                p += arr[sd] - arr[bd];
                bd = sd = i;
            }
        }
        // case [1, 2, 3, 4, 5] means each and every day price is increasing
        p += arr[sd] - arr[bd];
        System.out.println(p);
    }
}
