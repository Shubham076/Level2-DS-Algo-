// leetcode 128
import java.util.*;

//sequence
public class longestConsecutiveSequence {
    // O(nlogn) + O(n)
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i - 1]){
                if (nums[i] - nums[i - 1] == 1) {
                    cnt++;
                } else {
                    max = Math.max(max, cnt);
                    cnt = 1;
                }
            }
        }
        // for test case if after sorting arrays vecomes 1,2,3,4, 5 then else condition never hits
        max = Math.max(max, cnt);
        return max;
    }

    //O(N) solution
    public static int longestConsecutive2(int[] nums) {
    	HashSet<Integer> set = new HashSet<>();
		for(int i = 0; i < nums.length; i++){
			set.add(nums[i]);
		}
		int max = 0;
		for(int i = 0; i < nums.length; i++){
			int num = nums[i];
			int parent = num - 1;
			if(set.contains(parent)){
				continue;
			}
			else{
				int streak = 1;
				while(set.contains(num + streak)){
					streak += 1;
				}

				if(streak > max){
					max = streak;
				}
			}
		}
		return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(longestConsecutive2(nums));
    }
}
