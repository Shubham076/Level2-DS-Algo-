import java.util.Arrays;
import java.util.Scanner;
public class russianDoll {

    public static class Doll implements Comparable<Doll>{
        int h;
        int w;

        public Doll(int w , int h){
            this.w = w;
            this.h = h;
        }

        public int compareTo(Doll o){
            return this.w - o.w;
     }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        Doll[] arr = new Doll[n];

        for(int i = 0; i < n ; i++){
            String s = scn.nextLine();
            String[] parts = s.split(" ");
            arr[i] = new Doll(Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]));
}

        scn.close();
        Arrays.sort(arr);
        int omax = 0;
        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int  j = 0; j < i; j++){
                if(arr[j].h < arr[i].h && arr[j].w < arr[i].w){
                    if(dp[j] > max){
                        max = dp[j];
                    }
                }
            }

            dp[i] = 1 + max;
            if(dp[i] > omax){
                omax = dp[i];
            }

        } 

        System.out.println(omax);
    
    }
}