/*   leetcode 1283 same as koko eating bananas
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor, divide all the array by it, and sum the division's result. Find the smallest divisor such that the result mentioned above is less than or equal to threshold.

Each result of the division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 10/2 = 5).

It is guaranteed that there will be an answer.
*/
public class smallestDivisorGivenAThreshold {
    public static boolean isPossible(int n, int[] arr, int th){
        int v = 0;
        for(int i : arr){
            v += (int)Math.ceil(i * 1.0 / n);
        }

        return v <= th;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
        }

        if(threshold == nums.length){
            return max;
        }

        int lo = 1;
        int hi = max;
        int minDivisor = Integer.MAX_VALUE;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;

            if(isPossible(mid, nums, threshold)){
                minDivisor = mid;
                hi = mid - 1;
                //finding the smallest answer we can get
            }
            else{
                lo = mid + 1;
            }
        }

        return minDivisor;
    }
    public static void main(String[] args){
        int[] arr = {1, 2, 5, 9};
        int threshold = 5;
        System.out.println(smallestDivisor(arr, threshold));
    }
}
