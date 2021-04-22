import java.util.*;
class cntSubArrayWithEqual01And2s{
	public static int findMaxLength(int[] nums) {
		HashMap<String, Integer> map = new HashMap<>();  //key vs cnt
		int zc = 0;  //zeroCnt
		int oc = 0;  //oneCnt
		int tc = 0;  //twoCnt
		int del0 = oc - zc;
		int del1 = tc - oc; 
		String key = del0 + "#" + del1;
		map.put(key, 0);
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) zc++;
	        else if(nums[i] == 1) oc++;
	        else tc++;

	        del0 = oc - zc;
			del1 = tc - oc; 
			key = del0 + "#" + del1;

			if (map.containsKey(key))
				ans += map.get(key);

			map.put(key, map.getOrDefault(key, 0) + 1);
			
		}
		return ans;
	}
	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 2, 0, 1, 0};
		System.out.println(findMaxLength(arr));
	}
}