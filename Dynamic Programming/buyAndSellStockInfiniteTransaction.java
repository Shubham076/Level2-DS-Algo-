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
        int sd = 0 ;
        int bd = 0;
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

        p += arr[sd] - arr[bd];
        System.out.println(p);
    }
}
