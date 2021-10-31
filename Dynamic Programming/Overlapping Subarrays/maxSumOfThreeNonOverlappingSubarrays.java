/*  leetcode 689
Given an integer array nums and an integer k, find three non-overlapping subarrays of length k
with maximum sum and return them.
Return the result as a list of indices representing the starting position of each interval (0-indexed).
If there are multiple answers, return the lexicographically smallest one.
*/
public class maxSumOfThreeNonOverlappingSubarrays {
    static void print(int[] arr){
        for(int v: arr){
            System.out.print(v + " ");
        }
        System.out.println();
    }
    public static int[] maxSumOfThreeSubarrays(int[] arr, int k) {
        int[] ans = new int[3];
        int n = arr.length;
        int[] pmax = new int[n];  //ith index stores the maximum sum of sub-array of length k  from 0 to ith(inclusive == prefix max)
        int[] smax = new int[n];  //ith index stores the max of sum of sub-array of length k  from n - 1 to ith(inclusive == suffix max)
        int[] psum = new int[n];
        psum[0] = arr[0];
        
        for(int i = 1; i < n; i++){
            psum[i] = psum[i - 1] + arr[i];
        }
        int sum = 0;
        for(int i = 0; i < k; i++){
        	sum += arr[i];
        }
        pmax[k - 1] = sum;
        for(int i = k; i < arr.length; i++){
        	sum += arr[i] - arr[i - k];
        	pmax[i] = Math.max(sum, pmax[i - 1]);
        }

        sum = 0;
        for(int i = arr.length - 1; i >= n - k; i--){
        	sum += arr[i];
        }
        smax[n - k] = sum;
        for(int i = arr.length - k - 1; i >= 0; i--){
        	sum += arr[i] - arr[i + k];
        	smax[i] = Math.max(sum, smax[i + 1]);
        }
        
        // print(pmax);
        // print(smax);
        
        //bounds of middle array are from k to n - 2 * k;
        //ans = max(left[i - 1] + sum(middle) + right[i + k])
        //middle = psum[i + k - 1] - psum[i - 1];
        int maxSum = Integer.MIN_VALUE;
        int lsum = 0, rsum = 0;

        for(int i = k; i <= n - 2 * k; i++){
            int csum = pmax[i - 1] + (psum[i + k - 1] - psum[i - 1]) + smax[i + k];
            if(csum > maxSum){
                maxSum = csum;
                lsum = pmax[i - 1];
                rsum = smax[i + k];
                ans[1] = i;
            }
        } 
        // System.out.println("MaxSum: " + maxSum);

        //for lexicographically smaller indexes find the first time we found left sum
        for(int i = k - 1; i < ans[1]; i++){
            if(psum[i] - (i - k < 0 ? 0 : psum[i - k]) == lsum){
                ans[0] = i - k + 1;
                break;
            }
        }

        for(int i = ans[1] + k; i < n; i++){
            if(psum[i + k - 1] - psum[i - 1] == rsum){
                ans[2] = i;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        int[] arr = {1, 2, 1, 2, 6, 7, 5, 1};
        int[] ans = maxSumOfThreeSubarrays(arr, 2);
        System.out.println(ans[0] + " "+  ans[1] + " " + ans[2]);
    }
}
