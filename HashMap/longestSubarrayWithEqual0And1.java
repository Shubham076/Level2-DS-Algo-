import java.util.*;
class longestSubarrayWithEqual0And1{
	public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();  //sum vs index
        map.put(0, -1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
        	if(nums[i] == 0){
        		sum += -1;
        	}
        	else sum += nums[i];

        	if(map.containsKey(sum)){
        		int len = i - map.get(sum);
        		if(len > ans) ans = len;
        	}
        	else{
        		map.put(sum, i);
        	}
        }
        return ans;
    }
	public static void main(String[] args){
		int[] arr = {0, 1};
		System.out.println(findMaxLength(arr));
	}
}