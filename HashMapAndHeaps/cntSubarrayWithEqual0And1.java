/*
this problem can be reduced to subarray sum equal k
just assume all the zeros with -1
if the sum of subarray is equal to 0 means it contains equal no of -1 and 1 => 0 and 1
*/
import java.util.*;
class cntSubarrayWithEqual0And1 {
	public static int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> map = new HashMap<>();  //sum vs cnt
		map.put(0, 1);
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				sum += -1;
			} else sum += nums[i];

			if (map.containsKey(sum))
				ans += map.get(sum);
			
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1, 0, 0, 1, 0, 1, 1};
		System.out.println(findMaxLength(arr));
	}
}