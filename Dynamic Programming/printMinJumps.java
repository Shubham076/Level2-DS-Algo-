import java.util.ArrayDeque;
import java.util.Scanner;

public class printMinJumps {

    static class Pair{
        int i;
        int steps;  //allowed steps
        int jumps;  // min jumps to reach end of array ,  result of dp
        String psf;

        public Pair(int index , int steps , int jump , String psf){
            this.i = index;
            this.steps = steps;
            this.psf = psf;
            this.jumps = jump;
        }
    }

    static void printminPaths(Integer[] dp , int[] arr){

        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0 , arr[0] , dp[0] , 0+""));

        while(q.size() > 0){
            Pair rm = q.removeFirst();

            if(rm.jumps == 0){
                System.out.println(rm.psf + " .");
            }

            for(int j = 1; j <= rm.steps && rm.i + j < arr.length; j++){
                int ci = rm.i + j;
                if(dp[ci] != null && dp[ci] == rm.jumps - 1)
                    q.add(new Pair(ci , arr[ci] , dp[ci] , rm.psf + " -> "+ ci));

            }
        }


    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }

        for(int i = arr.length - 2; i >= 0; i--){
            int steps = arr[i];

            int min = Integer.MAX_VALUE;
            for(int j = 1; j <= steps && i + j < arr.length; j++){
                if(dp[i + j] != null && dp[i + j] < min){
                    min = dp[i + j];
                }
            }

            if(min != Integer.MAX_VALUE){
                dp[i] = 1 + min;
            }
        }

        System.out.println(dp[0]);

        printminPaths(dp, arr);


    }
}
