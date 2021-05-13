//leetcode 1031
import java.util.*;
class maximumSumOfTwoNonOverlappingArrays{
	// O(N) 
	public static int maxSumTwoNoOverlap(int[] arr, int l, int m) {
        int ans = 0;
        int n = arr.length;
        int[] pmax = new int[n];  //ith index stores the maximum sum of sub-array of length m  from 0 to ith(inclusive == prefix max)
        int[] smax = new int[n];  //ith index stores the max of sum of sub-array of length m  from n - 1 to ith(inclusive == suffix max)

        int sum = 0, j = 0, psum = 0, ssum = 0;  //prefix sum , suffix sum
        for(int i = 0; i < m - 1; i++){
        	sum += arr[i];
        }
        for(int i = m - 1; i < arr.length; i++){
        	sum += arr[i];
        	psum = Math.max(psum, sum);
        	pmax[i] = psum;
        	sum -= arr[j];
        	j++;
        }

        sum = 0;
        j = arr.length - 1;
        for(int i = arr.length - 1; i > arr.length - m; i--){
        	sum += arr[i];
        }
        for(int i = arr.length - m; i >= 0; i--){
        	sum += arr[i];
        	ssum = Math.max(ssum, sum);
        	smax[i] = ssum;
        	sum -= arr[j];
        	j--;
        }
  
        int lsum = 0;
        int msum = 0;
        j = 0;
        for(int i = 0; i < l - 1; i++){
        	lsum += arr[i];
        }

        //j is the starting of window and i is the ending of window
        for(int i = l - 1; i < n; i++){
        	lsum += arr[i];
        	msum = Math.max((j > 1 ? pmax[j - 1] : 0), (i < n - 1  ? smax[i + 1] : 0));
        	int total = lsum + msum;
        	ans = Math.max(ans, total);
        	lsum -= arr[j];
        	j++;
        }
        return ans;
    }

    public static void print(int[] arr){
    	for(int i : arr){
    		System.out.print(i + " ");
    	}
    	System.out.println();
    }
	public static void main(String[] args){
		int[] arr = {2, 1, 5, 6, 0, 9, 5, 0, 3, 8};
		int l = 4;
		int m = 3;
		System.out.println(maxSumTwoNoOverlap(arr, l, m));
	}
}