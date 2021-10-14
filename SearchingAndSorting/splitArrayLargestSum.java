/* leetcode 410
Given an array nums which consists of non-negative integers and an integer m, you can split
 the array into m non-empty continuous subarrays.
Write an algorithm to minimize the largest sum among these m subarrays.
*/
public class splitArrayLargestSum {

    public static int getNoOfSubArrays(int mid, int[] arr){
        int cnt = 1;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            if(sum + arr[i] > mid){
                cnt++;
                sum = 0;
            }
            sum += arr[i];
        }
        return cnt;
    }
    public static int method(int[] nums, int m){
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int i = 0; i < nums.length; i++){
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }
        // System.out.println(lo + " " + hi);
        int ans = hi;
        while(lo <= hi){
            int mid = lo + (hi - lo)/ 2;
            int r = getNoOfSubArrays(mid, nums);
            if(r <= m){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr = {7, 2, 5, 10, 8};
        int m = 2;
        System.out.println(method(arr, m));
    }
}
