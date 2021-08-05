/*
leetcode 710
what we do we will move all the blacklist points to the last
find find random between 0, N - blacklist.length

now how to move points to last
we cant create array 10 ^ 9
so what we will do we map all the blaclist to the last of array using hashmap

for eg n = 6, blacklist = {2, 3};
hashap = {2  => 5}, {3 => 4}
bow we will fnd random in first 1 -> 4
*/
import java.util.*;
class randomPickWithBlacklist {
	Random r;
	HashMap<Integer, Integer> map;
	int limit;
	public Solution(int n, int[] blacklist) {
		map = new HashMap<>();
		r = new Random();
		limit = n - blacklist.length;
		for (int val : blacklist) {
			map.put(val, -1);
		}
		int j = n - 1;
		for (int val : blacklist) {
			//if val is already present in the last we dont need to find a mapping
			if (val < limit) {
				while (map.containsKey(j)) {
					j--;
				}
				map.put(val, j);
				j--;
			}
		}
	}

	public int pick() {
		int i = r.nextInt(limit);
		if (map.containsKey(i)) {
			return map.get(i);
		} 
		else {
			return i;
		}
	}
}