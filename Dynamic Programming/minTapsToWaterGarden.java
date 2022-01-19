//leetcode 1326
import java.util.*;
public class minTapsToWaterGarden {
    //meaning of dp[i] min number of taps required to cover area of 0 -- i; 
    //O(n * r) r is ranges[i] space O(n)
    public static int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for(int i = 0; i <= n; i++){
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);

        /*
        why we are taking left not left - 1 look at the example below
        ranges = [0 , 0]
    
    <----------------------->
     -3  -2  -1  0  1  2  3 
     ranges[0] = 0 means we can cover area of (0, 0)
     ranges[1] = 1 means we can cover area of (1, 1)
     so answer would be -1 as we cant cover the area between [0, 1]

     but in below approach if we take 1 + dp[left - 1]
     then answer comes 1 which is wrong thats why we use 1 + dp[left]
        */
            for(int j = left; j <= right; j++){
                dp[j] = Math.min(dp[j], 1 + dp[left]);
            }
        }
        return dp[n] == n + 2 ? -1 : dp[n];
    }

    /*
    Greedy Approach
    o(n) time o(n) space
    The range each tap covers is: max(0, i-ranges[i]) (say l) to min(n, i+ranges[i]) (say r).
    Think of this range as a jump starting from the index max(0,i-ranges[i]) with maximum reach till 
    min(n, i+ranges[i]) - max(0, i-ranges[i]).
    To do this, we define a new array jumps where jumps[l] = max(jumps[l], r-l). 
    Now our problem boils down to calculating the minimum number of jumps required to reach
    the end of array.
    */ 
    static int minTaps2(int n, int[] ranges){
        int[] jumps = new int[n + 1];
        for(int i = 0; i <= n; i++){
            int l = Math.max(i - ranges[i], 0);
            int r = Math.min(i + ranges[i], n);
            jumps[l] = Math.max(jumps[i], r - l);
        }

        /*
        The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
        curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
        Once the current point reaches curEnd, then trigger another jump, and set the new curEnd
        with curFarthest, then keep the above steps, as the following:
        */
        int jump = 0, curend = 0, curFarthest = 0;
        for(int i = 0; i < jumps.length - 1; i++){
            if(i > curFarthest) return -1;
            curFarthest = Math.max(curFarthest, i + jumps[i]);
            if(i == curend){
                jump++;
                curend = curFarthest;
            }
        }
        return  curFarthest >= n ? jump : -1;
    }
    public static void main(String[] args){
        int n = 3;
        int[] arr = {0, 0, 0, 0};
        System.out.println(minTaps(n, arr));
        System.out.println(minTaps2(n, arr));
    }
}
