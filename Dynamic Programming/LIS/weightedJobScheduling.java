/* https://www.geeksforgeeks.org/weighted-job-scheduling-set-2-using-lis/?ref=rp
Given N jobs where every job is represented by following three elements of it.
1. Start Time 
2. Finish Time 
3. Profit or Value Associated
Find the maximum profit subset of jobs such that no two jobs in the subset overlap.
*/
import java.util.*;
public class weightedJobScheduling {
    public static void main(String[] args){
        int[][] jobs = {{1, 2, 50}, {3, 5, 20}, {6, 19, 100}, {2, 100, 200}};
        int[] dp = new int[jobs.length];
        Arrays.sort(jobs, (a, b) ->{
            if(a[0] != b[0]){
                return a[0] - b[0];
            }
            else return a[1] - b[1];
        });
        dp[0] = jobs[0][2];
        int ans = dp[0];
        for(int i = 1; i < jobs.length; i++){
            int max = 0;
            for(int j = 0; j < i; j++){
                if(jobs[j][1] < jobs[i][1]){
                    max = Math.max(max, jobs[j][2]);
                }
            }
            dp[i] = jobs[i][2] + max;
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);
    }
}
