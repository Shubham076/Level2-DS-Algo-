import java.util.*;
public class highwayBillboardProblem {

    //O(n * n) solution
    public static int maxRevenue(int m, int[] pos, int[] rev, int t){
        int[] dp = new int[pos.length];
        int ans = Integer.MIN_VALUE;
        dp[0] = rev[0];

        for(int i = 1; i < pos.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                int dis = pos[i] - pos[j];
                if(dis > t){
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + rev[i];
            
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    //O(m)
    static int maxRevenue2(int m, int[] pos, int[] rev, int t){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < pos.length; i++){
            map.put(pos[i], rev[i]);
        }
        int[] dp = new int[m + 1];
        for(int i = 1; i <= m; i++){
            if(map.containsKey(i)){
                //means board is present so we have to choice whether to add board in this pos or not
                dp[i] = Math.max(dp[i - 1], map.get(i) + dp[i - t - 1]);
            }
            else{
                //means board is not present so revenue is equal to revenue of previous
                dp[i] = dp[i - 1];
            }
        }
        return dp[m];
    }
    public static void main(String[] args){
        int d = 20;
        int[] pos = {6, 7, 12, 13, 14}; //pos of the billboard
        int[] rev = {5, 6, 5, 3, 1};   //revenue of particular billboard
        int t = 5;

        System.out.println(maxRevenue(d, pos, rev, t));
        System.out.println(maxRevenue2(d, pos, rev, t));
    }
}
