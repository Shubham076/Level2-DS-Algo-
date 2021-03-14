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

    static class lisPair{
        String psf;
        int val;

        public lisPair(String psf, int val){
            this.psf = psf;
            this.val = val;
        }

        public String toString(){
            return this.psf + " " + this.val;
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

    // for printing one of the answers
    // public static void alternateMethod(int[] arr){
    //     lisPair[] dp = new lisPair[arr.length];
    //     lisPair omax = new lisPair("", 0);

    //     for (int i = 0; i < dp.length; i++) {
    //         lisPair max = new lisPair("", 0);
    //         for (int j = 0; j < i; j++) {
    //             if (arr[j] <= arr[i]) {
    //                 if (dp[j].val > max.val) {
    //                     max.val = dp[j].val;
    //                     max.psf = dp[j].psf;
    //                 }
    //             }
    //         }
    //         dp[i] = new lisPair(max.psf + " " + arr[i], (1 + max.val));
    //         if (dp[i].val > omax.val) {
    //             omax.val = dp[i].val;
    //             omax.psf = dp[i].psf;
    //         }
    //     }

    //     System.out.println(omax.val + "=>" + omax.psf);
    // }

}