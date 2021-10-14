/*  leetcode 532
Given an array of integers nums and an integer k, return the number of unique
 k-diff pairs in the array.
A k-diff pair is an integer pair (nums[i], nums[j]), where the following are true:
0 <= i < j < nums.length
|nums[i] - nums[j]| == k
Notice that |val| denotes the absolute value of val.
*/
import java.util.*;
public class kdiffPairsInArray {
    public int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for(int v: nums)
            m.put(v, m.getOrDefault(v, 0) + 1);

        int cnt = 0;
        for(int v: m.keySet()){
            if(k > 0 && m.containsKey(v + k) || k == 0 && m.get(v) > 1){
                cnt++;
            }
        }
        return cnt;
    }       
}
