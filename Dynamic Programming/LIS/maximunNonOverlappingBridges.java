import java.util.Arrays;
import java.util.Scanner;
public class maximunNonOverlappingBridges {

    public static class Bridge implements Comparable<Bridge>{
        int north;
        int south;

        public Bridge(int n , int s){
            this.north = n;
            this.south = s;
        }

        public int compareTo(Bridge o){
            if(this.north != o.north){
            return this.north - o.north;
            }
            else{
                return this.south - o.south;
            }
        }
     }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = Integer.parseInt(scn.nextLine());
        Bridge[] arr = new Bridge[n];

        for(int i = 0; i < n ; i++){
            String s = scn.nextLine();
            String[] parts = s.split(" ");
            arr[i] = new Bridge(Integer.parseInt(parts[0]) , Integer.parseInt(parts[1]));
}

        scn.close();
        Arrays.sort(arr);
        int omax = 0;
        int[] dp = new int[n];
        for(int i = 0; i < dp.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(arr[j].south < arr[i].south){
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
