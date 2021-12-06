//leetcode 347
import java.util.*;
class topKFrequentElements {

	// O(N)
	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		// corner case: if there is only one number in nums, we need the bucket has index 1.
		ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			int v = nums[i];
			map.put(v , map.getOrDefault(v, 0) + 1);
		}

		for (int n : map.keySet()) {
			int cnt = map.get(n);
			if (buckets[cnt] != null) {
				buckets[cnt].add(n);
			}
			else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(n);
				buckets[cnt] = temp;
			}
		}

		int[] ans = new int[k];
		int p = 0;
		for (int i = buckets.length - 1; i >= 0 && k > 0; i--) {
			if (buckets[i] != null) {
				for (int j = 0; j < buckets[i].size() && k > 0; j++) {
					ans[p] = buckets[i].get(j);
					p++;
					k--;
				}
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 2, 3};
		int k = 2;
		int[] ans = topKFrequent(arr, k);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
}