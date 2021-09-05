import java.util.ArrayDeque;
import java.util.Scanner;

class printLongestIncreasingSubsequences  {
    static class Pair{
        int i;  //index 
        int l;  //length of subsequence
        String psf;
        int val;  //val stored in array 

        public Pair(int i , int val , int l, String psf){
            this.i = i;
            this.psf = psf;
            this.l = l;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        scn.close();

        int omax = 0;

        for (int i = 0; i < dp.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i]) {
                    if (dp[j] > max) {
                        max = dp[j];
                    }
                }
            }

            dp[i] = 1 + max;
            if (dp[i] > omax) {
                omax = dp[i];
            }
        }

        System.out.println(omax);
        // alternateMethod(arr);

        ArrayDeque<Pair> q = new ArrayDeque<>();
        for(int i = 0 ; i < dp.length; i++){
            if(omax == dp[i])
                q.add(new Pair(i , arr[i] , omax ,arr[i] + ""));
        }

        while(q.size() > 0){
            Pair rm = q.removeFirst();

            if(rm.l == 1){
                System.out.println(rm.psf);
            }

            for(int j = 0; j < rm.i; j++){
                if(dp[j] == rm.l - 1  && arr[j] <= rm.val ){
                    q.add(new Pair(j , arr[j] , dp[j] ,arr[j] + " -> "+ rm.psf));
                }
            }
        }
    }
}