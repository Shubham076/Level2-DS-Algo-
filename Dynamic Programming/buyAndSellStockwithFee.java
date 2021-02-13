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
        int obsp = -arr[0];
        int ossp = 0;

        for(int i = 1; i < arr.length; i++){

            int nssp = 0;
            int nbsp = 0;

            if(ossp - arr[i] > obsp){
                nbsp = ossp - arr[i];
            }
            else{
                nbsp = obsp;
            }

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
