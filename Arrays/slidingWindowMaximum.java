//leetcode 239
import java.util.*;
class slidingWindowMaximum{
	// O(nK)
	public static int[] maxSlidingWindow1(int[] nums, int k) {
     	int max = Integer.MIN_VALUE;
     	int[] ans = new int[nums.length - k + 1];
     	ArrayList<Integer> list = new ArrayList<>();
     	for(int i = 0; i < k - 1; i++){
     		list.add(nums[i]);
     	}

     	int j = 0;
     	for(int i = k - 1; i < nums.length; i++){
     		list.add(nums[i]);
     		ans[j] = Collections.max(list);
     		list.remove(0);
     		j++;
     	} 
     	return ans;  
    }

    //using prefix max and suffix max
    // find the starting point of each window of size k  = (i % k == 0)
    // find the end point of each window of size k  = ((i + 1) % k == 0)
    //intution dividing nums into windows of k sizes and calculate prefix and suffix max for each window seperately 
    //instead of calculating for the entire array
    //for eg if array is like this 1 3 -1 -3 5 3 6 9 8
    // windows like this   1 3 -1 | -3 5 3 | 6 9 8   3 windows
    // pmax                1 3 3  | -3 5 5 | 6 9 9
    // smax                3 3 -1 |  5 5 3 | 9 9 8
    public static int[] maxSlidingWindow2(int[] nums, int k) {
    	int n = nums.length;
    	int[] pmax = new int[n];
    	int[] smax = new int[n];
    	int[] ans = new int[n - k + 1];
    	pmax[0] = nums[0];
    	smax[n - 1] = nums[n - 1];

    	for(int i = 1; i < nums.length; i++){
    		if(i % k == 0){
    			//starting point of each window
    			pmax[i] = nums[i];
    		}
    		else{
    			pmax[i] = Math.max(pmax[i - 1], nums[i]);
    		}
    	}

    	//suffix max
    	for(int i = nums.length - 2; i >= 0; i--){
    		if((i + 1) % k == 0){
    			//ending point of window
    			smax[i] = nums[i];
    		}
    		else{
    			smax[i] = Math.max(smax[i + 1], nums[i]);
    		}
    	}
    	for(int i = 0; i < ans.length; i++){
    		ans[i] = Math.max(smax[i], (i + k - 1 <= n - 1 ? pmax[i + k - 1] : 0));
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
    	int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
    	int k = 3;
    	int[] ans = maxSlidingWindow2(arr, k);
    	for(int i : ans){
    		System.out.print(i + " ");
    	}
    	System.out.println();
    }
}