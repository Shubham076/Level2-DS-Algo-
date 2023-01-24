/*
leetcode 381
maintainng a hasmap of number vs set containing indices of the numbe;
*/
import java.util.*;
class insertDeleteRandomDuplicatesAllowed {
	HashMap<Integer, HashSet<Integer>> map; //no to idx mapping
	ArrayList<Integer> list;   //idx to number mapping
	Random r;
	/** Initialize your data structure here. */
	public insertDeleteRandomDuplicatesAllowed() {
		map = new HashMap<>();
		list = new ArrayList<>();
		r = new Random();
	}
`
	/** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
	public boolean insert(int val) {
		if (map.containsKey(val)) {
			map.get(val).add(list.size());
			list.add(val);
			return false;
		} 
		else {
			HashSet<Integer> set = new HashSet<>();
			set.add(list.size());
			map.put(val, set);
			list.add(val);
			return true;
		}
	}

	/** Removes a value from the collection. Returns true if the collection contained the specified element. */
	public boolean remove(int val) {
		if (map.containsKey(val)) {
			//last idx value
			int n = list.get(list.size() - 1);
			int idx = -1;
			for (int i : map.get(val)) {
				if (idx == -1) {
					idx = i;
					break;
				}
			}

			if (idx == list.size() - 1) {
				list.remove(idx);
				map.get(val).remove(idx);
				if (map.get(val).size() == 0) {
					map.remove(val);
				}
			} 
			else {
				// swap with the last idx
				list.set(idx, n);
				list.remove(list.size() - 1);

				//update the data in the map
				map.get(val).remove(idx);
				if (map.get(val).size() == 0) {
					map.remove(val);
				}

				map.get(n).remove(list.size());
				map.get(n).add(idx);
				
			}
			return true;
		} 
		else {
			return false;
		}
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		int idx = r.nextInt(list.size());
		return list.get(idx);
	}
}