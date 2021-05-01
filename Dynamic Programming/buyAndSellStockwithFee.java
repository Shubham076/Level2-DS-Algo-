import java.util.Scanner;

public class buyAndSellStockwithFee {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        int fees = scn.nextInt();
        scn.close();
        int obsp = -arr[0];  //bought state price  - BSBSB ONE BUY EXTRA(ONE EXTRA SHARE)
        int ossp = 0;      // sold state price - BSBSBS

        for(int i = 1; i < arr.length; i++){
            int nssp = 0;
            int nbsp = 0;

            //purane sold pe aj buy krle ya phir na kre
            if(ossp - arr[i] > obsp){
                nbsp = ossp - arr[i];
            }
            else{
                nbsp = obsp;
            }

            //purane buy pe aj sell krde or fees bhi add krde
            if(obsp + arr[i] - fees > ossp){
                nssp = obsp + arr[i] - fees;
            }
            else{
                nssp = ossp;
            }

            obsp = nbsp;
            ossp = nssp;
        }

        System.out.println(ossp);
    }
}
