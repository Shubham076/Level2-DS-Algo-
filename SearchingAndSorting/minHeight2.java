/*
https://www.geeksforgeeks.org/minimize-the-maximum-difference-between-the-heights/
efficient O(NlogN);
*/

// 1 2 3 5
import java.util.*;
class minHeight2{
	static int mindiff(int[] arr, int k) throws IOException{
         Arrays.sort(arr);
         int n = arr.length;
        int ans = arr[n - 1] - arr[0];
        for(int i = 1; i < n; i++){
        	if(arr[i] >= k){
        		int max = Math.max(arr[i - 1] + k, arr[n - 1] - k);
        		int min = Math.min(arr[i] - k, arr[0] + k);
        		ans = Math.min(ans, max - min);
        	}
        }
        return ans;
    }
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 2};
		System.out.println(mindiff(arr, 2));
	}
}