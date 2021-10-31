/*
leetcode 954
as we can re-order the elements we simply make pairs
if we can make pairs then true otherwair false;
*/
import java.util.*;
class arrayOfDoublesPairs {
	public static void removeFromMap(int n, HashMap<Integer, Integer> map) {
		int v = map.getOrDefault(n, 0);
		if (v > 1) {
			map.put(n, v - 1);
		}
		else {
			map.remove(n);
		}
	}

	public boolean canReorderDoubled(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i : arr) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		Arrays.sort(arr);
		for (int i : arr) {
			if (!map.containsKey(i)) continue; //means already processed
			int di = i > 0 ? i * 2 : i / 2;  //double of i

			//if number is neagtive and odd or no is even and map doesnt contains its double 
			if (i < 0 && i % 2 != 0 || !map.containsKey(di)) {
				//as we cant make a pair
				return false;
			} 
			else {
				//for cases like 0 double of zero is zero so in function we have to check getOrDefault
				//because in case of 0 both i & di exist first we are removing it may be possible after 
				//removing di it can be possible 0 does 
				//exist in map
				removeFromMap(i, map);
				removeFromMap(di, map);
			}
		}
		return true;
	}
}