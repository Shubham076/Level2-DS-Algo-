/*
  leetcode 380
*/
 import java.util.*;
class insertDeleteRandom{
	HashMap<Integer, Integer> map;
	ArrayList<Integer> list;
	Random r;
	/** Initialize your data structure here. */
    public insertDeleteRandom() {
    	map = new HashMap<>();
    	list = new ArrayList<>();
    	r = new Random();    
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    	if(!map.containsKey(val)){
        	map.put(val, list.size());
        	list.add(val);
        	return true;
    	}
    	else{
    		return false;
    	}
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
        	int idx = map.get(val);
        	if(idx == list.size() - 1){
        		list.remove(list.size() - 1);
        		map.remove(val);
        	}
        	else{
        		int n = list.get(list.size() - 1);
        		
        		list.set(idx, n);
        		map.put(n, idx);

        		map.remove(val);
        		list.remove(list.size() - 1);
        	}
        	return true;	
        }
        else{
        	return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(r.nextInt(list.size()));
    }
}