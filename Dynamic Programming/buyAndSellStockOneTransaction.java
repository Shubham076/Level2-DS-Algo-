import java.util.Scanner;

/**
 * buyAndSeelStockOneTransaction
 */
public class buyAndSellStockOneTransaction {

    public static void main(String[] args) {
        Scanner scn =  new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        scn.close();
        
        int lsf = Integer.MAX_VALUE;
        // lsf  = least so far
        // op = overall profit  p = profit
        int op = 0;
        int p = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < lsf){
                lsf = arr[i];
            }

            p = arr[i] - lsf;
            if(p > op){
                op = p;
            }
        }

        System.out.println(op);
    }
}