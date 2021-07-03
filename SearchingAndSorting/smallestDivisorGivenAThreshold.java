//leetcode 1283 same as koko eating bananas
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
