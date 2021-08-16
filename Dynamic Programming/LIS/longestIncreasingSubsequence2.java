//nlogn
// each new element has choice either increase the current lis by one or replace the previous number to increase its range 
public class longestIncreasingSubsequence2 {
    public static int lis(int[] arr) {
        int[] dp = new int[arr.length];
        int max = 0;
        for(int val: arr){
            int lo = 0;
            int hi = max;

            while(lo < hi){
                int mid = lo + (hi - lo) / 2;
                if(dp[mid] >= val){
                    hi = mid;
                }
                else{
                    lo = mid + 1;
                }
            }

            dp[lo] = val;

            //means the current is greater than all so we can increase the current lis by 1
            if(lo == max){
                max++;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 5, 6};
        System.out.println(lis(arr));
    }
}
