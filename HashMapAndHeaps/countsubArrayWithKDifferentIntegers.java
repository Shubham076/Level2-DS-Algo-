/*
leetcode 992
in this problem we have to subarray with  k diff integers
so what we will do we will
	cnt of subarray with atmost k diff integer = c1
	cnt of subarray with atmost k - 1 diff integers = c2
	ans = c1 - c2 => cnt of exact k diff integers
*/
import java.util.*;
class countsubArrayWithKDifferentIntegers {
	public static int findAtmostK(int[] nums , int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int i = -1;
		int j = -1;
		int cnt = 0;
		while (true) {
			while (i < nums.length - 1) {
				i++;
				map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
				if (map.size() <= k) {
					cnt += (i - j);
				}
				else {
					break;
				}
			}

			if (i == nums.length - 1 && map.size() <= k) {
				break;
			}

			while (j < i) {
				j++;
				int v = map.get(nums[j]);
				if (v > 1) {
					map.put(nums[j], v - 1);
				} 
				else {
					map.remove(nums[j]);
				}
				if (map.size() <= k) {
					cnt += (i - j);
					break;
				}
			}

		}
		return cnt;
	}
	public int subarraysWithKDistinct(int[] nums, int k) {
		int c1 = findAtmostK(nums, k);
		int c2 = findAtmostK(nums, k - 1);
		// System.out.println(c1);
		return c1 - c2;
	}
}
