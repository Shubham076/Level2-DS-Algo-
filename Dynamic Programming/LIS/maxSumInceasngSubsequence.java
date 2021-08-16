import java.util.Scanner;

public class maxSumInceasngSubsequence {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }

        scn.close();

        int omax = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length ; i++){
            Integer max = null;
            for(int j = 0; j < i ; j++){
                if(arr[j] <= arr[i])

                if(max == null){
                    max = dp[j];
                }
                else if(dp[j] > max){
                        max = dp[j];
                    }
                }
            

            if(max == null){
                dp[i] = arr[i];
            }

            else{
                dp[i] = arr[i] + max;
            }
            if(dp[i] > omax){
                omax = dp[i];
            }
        }

        System.out.println(omax);
    }    
}
