import java.util.ArrayDeque;
import java.util.Scanner;

public class printMinPath {

    static class Pair{
        String psf;
        int i;
        int j;

        public Pair(String psf , int i , int j){
            this.psf = psf;
            this.i = i;
            this.j = j;
        }
    } 
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] arr = new int[n][m];

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                arr[i][j] = scn.nextInt();
            }
        }
        scn.close();
        int[][] dp = new int[n][m];

        for(int i = arr.length - 1; i >= 0; i--){
            for(int j = arr[0].length - 1; j >= 0; j--){

                if(i == arr.length - 1 && j == arr[0].length -1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == arr.length - 1){
                    dp[i][j] = arr[i][j] + dp[i][j + 1]; 
                }
                else if(j == dp[0].length -1){
                    dp[i][j] = arr[i][j] + dp[i + 1][j];
                }
                else{
                    dp[i][j] = arr[i][j] + Math.min(dp[i][j + 1] , dp[i + 1][j]);
                }
            }
        }

        System.out.println(dp[0][0]);

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair("" , 0 , 0));

        while(queue.size() > 0){

            Pair rm = queue.removeFirst();
            if(rm.i == dp.length -1 && rm.j == dp[0].length -1){
                System.out.println(rm.psf);
            }
            else if(rm.i == dp.length - 1){
                queue.add(new Pair(rm.psf + "H" , rm.i , rm.j + 1));
            }
            else if(rm.j == dp[0].length - 1){
                queue.add(new Pair(rm.psf + "V" , rm.i + 1  , rm.j));
            }
            else{
                if(dp[rm.i][rm.j + 1] < dp[rm.i + 1][rm.j]){
                    queue.add(new Pair(rm.psf + "H" , rm.i , rm.j + 1));
                }
                else if(dp[rm.i][rm.j + 1] > dp[rm.i + 1][rm.j]){
                    queue.add(new Pair(rm.psf + "V" , rm.i + 1 , rm.j));
                }
                else{
                    queue.add(new Pair(rm.psf + "V" , rm.i + 1 , rm.j));
                    queue.add(new Pair(rm.psf + "H" , rm.i , rm.j + 1));


                }

            }
        }
    }
}
