//leetcode 219
import java.util.*;
class containsDuplicates2{
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
        	if(map.containsKey(nums[i])){
        		int diff = Math.abs(map.get(nums[i]) - i);
        		if(diff <= k){
        			return true;
        		}
        	}
        	else{
        		map.put(nums[i], i);
        	}
        }
        return false;
    }
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1};
		int k = 3;
		System.out.println(containsNearbyDuplicate(arr, k));	
	}
}